package com.mobilidade.mobilidade.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.google.gson.annotations.SerializedName;
import com.mobilidade.mobilidade.constants.TIPO_AVALIACAO;
import com.mobilidade.mobilidade.constants.TIPO_TRANSPORTE;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Empresa {
    
    @Field(name = "nome")
    @SerializedName("nome")
    private String nome;
    
    @Field(name = "identificador")
    @SerializedName("identificador")
    private String identificador;

}
