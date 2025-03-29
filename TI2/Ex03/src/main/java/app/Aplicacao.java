package app;

import static spark.Spark.*;

import service.TimeService;

public class Aplicacao {
    public static void main(String[] args) {
        port(6789);
        TimeService service = new TimeService();

        // POST: Cadastrar
        post("/times", (request, response) -> service.add(request, response));

        // GET: Buscar por ID
        get("/times/:id", (request, response) -> service.get(request, response));

        // GET: Remover
        get("/times/delete/:id", (request, response) -> service.remove(request, response));

        // POST: Atualizar
        post("/times/update/:id", (request, response) -> service.update(request, response));

        //GET: Listar todos
        get("/times", (request, response) -> service.getAll(request, response));
    }
}