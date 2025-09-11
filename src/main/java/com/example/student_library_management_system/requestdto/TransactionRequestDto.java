package com.example.student_library_management_system.requestdto;

import com.example.student_library_management_system.enums.TransactionName;
import com.example.student_library_management_system.enums.TransactionStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TransactionRequestDto {

    private TransactionName transaction_name;
    private TransactionStatus transaction_status;
    private int bookId;
    private int cardId;

}
