import java.util.Map;

public record ConsultaTasaDeCambio(String result,
                                   String time_last_update_utc,
                                   String time_next_update_utc,
                                   String base_code,
                                   String target_code,
                                   //Map<String, Double> conversion_rates
                                   double conversion_rate,
                                   double conversion_result) {}
