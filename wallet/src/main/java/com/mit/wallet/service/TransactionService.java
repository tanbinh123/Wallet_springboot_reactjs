package com.mit.wallet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mit.wallet.entity.Transaction;
import com.mit.wallet.entity.Wallet;
import com.mit.wallet.exceptions.WalletException;
import com.mit.wallet.repository.TransactionRepository;
import com.mit.wallet.repository.WalletRepository;


@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private WalletRepository walletRepository;
	
	public List<Transaction> getAll(Long walletId){
		Optional<Wallet> wallet = walletRepository.findById(walletId);
		if(wallet.isPresent()) {
			return transactionRepository.findByWallet(wallet.get());
		}
		return null;
	
	}
	
//	public Wallet getById(Long id) {
//		Optional<Wallet> wallet = walletRepository.findById(id);
//		if(wallet.isPresent()) {
//			return wallet.get();
//		}
//		throw new WalletException("Wallet with"+id+"does not exists!!");
//	}
//	
	public Transaction createOrUpdate (Long walletId,Transaction transaction) {
	  Optional<Wallet> wallet = walletRepository.findById(walletId);
	  if(wallet.isPresent()) {
		  transaction.setWallet(wallet.get());
		  transactionRepository.save(transaction);
		  return transaction;
	  }
	  return null;
	}
//	
//	public boolean delete(Long id) {
//		Optional<Wallet> wallet = walletRepository.findById(id);
//		if(wallet.isPresent()) {
//			walletRepository.delete(wallet.get());
//			return true;
//		}
//		throw new WalletException("Wallet with"+id+"does not exists!!");
//	}
}
