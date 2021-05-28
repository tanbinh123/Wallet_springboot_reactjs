import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import DashboardItem from './DashboardItem'
import {connect} from 'react-redux'
import {getWallets} from "../../actions/projectActions"

export class Dashboard extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
             totalBalance:0.0
        }
    }
    

    componentWillReceiveProps(nextProps){
        if(nextProps.wallets){
            let totalBal = 0
           for(let i=0;i<nextProps.wallets.length;i++){
               totalBal=totalBal+nextProps.wallets[i].currentBalance
           }
            this.setState({totalBalance:totalBal})
        }
    }

    componentDidMount(){
        this.props.getWallets()
    }

    render() {
        const wallets =this.props.wallets
        const walletComponent = wallets.map(wallet=>(<DashboardItem key={wallet.id} wallet={wallet} />))
     
        return (
            <div class="projects">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="display-4 text-center">My Wallets</h1>
                            <br />
                            <div class="btn-group">
                                <button type="button" class="btn btn-info btn-lg dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Create new
                            </button>
                                <div class="dropdown-menu">
                                    <Link class="dropdown-item" to="/createwallet">Wallet</Link>
                                    <button disabled class="dropdown-item">Transaction</button>
                                </div>
                            </div>
                            <br />
                            <div class="card text-center">
                                <div class="card-header bg-success text-white">
                                    <h4>Current Balance (Total)</h4>
                                    <h1>Rs. {this.state.totalBalance}</h1>
                                </div>
                            </div>
                            <hr />
                            {
                                // <!-- Project Item Component -->
                            }

                            {walletComponent}


                            {
                                //  <!-- End of Project Item Component -->
                            }

                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

const mapStateToProps =(state) => ({
    wallets:state.wallet.wallets
})

export default connect(mapStateToProps,{getWallets}) (Dashboard)
