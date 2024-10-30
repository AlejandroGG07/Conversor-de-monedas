public record Monedas(String base_code,
                      String target_code,
                      double conversion_rate

) {
    public Monedas(String base_code, String target_code, double conversion_rate) {
        this.base_code = base_code;
        this.target_code = target_code;
        this.conversion_rate = conversion_rate;
    }
}
