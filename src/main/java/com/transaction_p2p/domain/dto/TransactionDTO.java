package com.transaction_p2p.domain.dto;

import java.math.BigDecimal;

public record TransactionDTO (BigDecimal value, Long senderId, Long receiverId ){
}
