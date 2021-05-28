import React from 'react';
import './App.css';
import Nav from './components/shared/Nav';
import 'bootstrap/dist/css/bootstrap.min.css';
import Welcome from './components/Welcome';
import { BrowserRouter, Route ,Switch } from 'react-router-dom'
import Dashboard from './components/dashboard/Dashboard';
import CreateWallet from './components/dashboard/operations/CreateWallet';
import NotFound from './components/shared/NotFound';
import {Provider} from 'react-redux';
import store from './Store'
import UpdateWallet  from './components/dashboard/operations/UpdateWallet';

function App() {
  return (
    <Provider store={store}>
    <BrowserRouter>
     <Route path="/" component={Nav} />
     <Switch>
      <Route path="/" exact component={Welcome} />
      <Route path="/dashboard" exact component={Dashboard} />
      <Route path="/createwallet" exact component={CreateWallet} />
      <Route path="/updatewallet/:id" exact component={UpdateWallet}/>
      <Route path="/" component={NotFound} />
     </Switch>
    </BrowserRouter>
    </Provider>

  );
}

export default App;
