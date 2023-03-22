package by.teachmeskills.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {

    private String accountName;
    private String type;
    private String industry;
    private String phone;
}
