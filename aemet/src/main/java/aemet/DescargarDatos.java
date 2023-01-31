package aemet;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;

public class DescargarDatos {

	public static void main(String[] args) throws IOException, InterruptedException {
		String server="https://opendata.aemet.es/opendata/";
		String endPoint="api/observacion/convencional/todas/";
		String apiKey="?api_key=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyMTAxNzZAaWVzc2llcnJhZGVndWFyYS5jb20iLCJqdGkiOiI2MjY4MjljNy00NjdlLTQ5OGQtOGZmZS1mYjJhNjMyZGQwNjMiLCJpc3MiOiJBRU1FVCIsImlhdCI6MTY3NTE1NDYxMSwidXNlcklkIjoiNjI2ODI5YzctNDY3ZS00OThkLThmZmUtZmIyYTYzMmRkMDYzIiwicm9sZSI6IiJ9.unJ5MW13fGvSUXLRkfzx5MRwg0Vv1kIKe4QDrRRPcsw";
		HttpClient cliente= HttpClient.newHttpClient();
		HttpRequest req= HttpRequest.newBuilder()
				.uri(URI.create(server+endPoint+apiKey))
				.GET()
				.build();
		
		HttpResponse<String> res=cliente.send(req, HttpResponse.BodyHandlers.ofString());
		
		System.out.println(res.body());
		
		System.out.println(res);
		
		
		//usar jackson para obtener la cadena de datos  y metadatos
		
		//hacer las peticiones correspondientes a esos datos json
		
		//filtrando por el idema de Huesca (9901x)
	}

}
