package com.samta.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOutlet {
    private Long roleId;
    private String outletName;
    private String location;
    private String email;
    private String phone;
}
