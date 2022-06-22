//Badysiak Paweł s21166 gr.41c
public class Symbol {

    private String character;
    private String code;

    public Symbol(String s) {
        final var split = s.split(":");
        this.character = split[0];
        this.code = split[1];
    }

    public String getCharacter() {
        return character;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "character='" + character + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
