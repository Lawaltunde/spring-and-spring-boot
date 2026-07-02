package com.amigoscode.account;

// TODO: 24 - Implement the transfer method:
//  - Annotate the method with @Transactional
//  - Find both accounts by ID (throw RuntimeException if not found)
//  - Check if sender has sufficient balance (throw RuntimeException if not)
//  - Subtract amount from sender's balance
//  - Add amount to receiver's balance
//  - Save both accounts
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void transfer(Long senderId, Long receiverId, double amount) {
        // TODO: 24 - Implement transfer logic here
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // TODO: 25 - Create a method transferWithBug(Long senderId, Long receiverId, double amount):
    //  - Same as transfer but throw a RuntimeException AFTER debiting the sender
    //    and BEFORE crediting the receiver
    //  - This simulates a failure mid-transaction
    //  - Annotate with @Transactional — verify the rollback prevents money loss

}
