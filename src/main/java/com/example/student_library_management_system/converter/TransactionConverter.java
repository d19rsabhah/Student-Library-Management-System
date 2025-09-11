package com.example.student_library_management_system.converter;

import com.example.student_library_management_system.model.Transaction;
import com.example.student_library_management_system.requestdto.TransactionRequestDto;

public class TransactionConverter {
    public static Transaction convertRequestDtoIntoTransactionModel(TransactionRequestDto transactionRequestDto){
        return Transaction.builder().transactionName(transactionRequestDto.getTransaction_name())
                .transactionStatus(transactionRequestDto.getTransaction_status()).build();
    }
}
