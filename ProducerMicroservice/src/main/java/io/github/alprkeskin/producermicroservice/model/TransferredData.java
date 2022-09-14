package io.github.alprkeskin.producermicroservice.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferredData implements Serializable {
    private int sampleIntegerField;
    private String sampleStringField;
}
