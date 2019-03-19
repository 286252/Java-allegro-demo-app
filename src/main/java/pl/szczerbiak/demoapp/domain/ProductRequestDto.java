package pl.szczerbiak.demoapp.domain;

public class ProductRequestDto {
    private final String name;

    public ProductRequestDto(String name) {
        this.name = name;
    }

    public boolean isValid(){
        return name != null && !name.isBlank();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ProductRequestDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
