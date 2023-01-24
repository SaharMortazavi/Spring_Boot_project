package se.jensenyh.javacourse.saltmerch.backend.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ModelTests
{
    static final int id = 1;
    static final String category= "Jacket";
    static final String title="coat";
    static final String description="";
    static final String previewImage="image.jpg";
    @Test
    public void testThirdProductConstructor(){
        Product product = new Product(1,"Jacket","coat","","image.jpg");
        assertThat(product.id).isNotNull();
    }
}
