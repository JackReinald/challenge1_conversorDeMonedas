import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {
    public void guardarJson(ConsultaTasaDeCambio tasaDeCambio) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter(tasaDeCambio.base_code()+"2"+tasaDeCambio.target_code()+".json");
        escritura.write(gson.toJson(tasaDeCambio));
        escritura.close();

    }
}
