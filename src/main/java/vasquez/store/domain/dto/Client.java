package vasquez.store.domain.dto;

import lombok.Data;

@Data
public class Client {
    private String clientId;
    private String name;
    private String lastname;
    private String phone;
    private String address;
    private String email;
}
