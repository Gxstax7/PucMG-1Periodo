package service;

import dao.TimeDAO;
import model.Time;
import spark.Request;
import spark.Response;

public class TimeService {
    private TimeDAO timeDAO;

    public TimeService() {
        timeDAO = new TimeDAO();
        timeDAO.conectar(); // Conecta ao PostgreSQL
    }

    // CADASTRAR Time (POST)
    public Object add(Request request, Response response) {
        try {
            int codigo = Integer.parseInt(request.queryParams("codigo"));
            String nome = request.queryParams("nome");
            String estadio = request.queryParams("estadio");
            int fundacao = Integer.parseInt(request.queryParams("fundacao"));
            String estado = request.queryParams("estado");

            Time time = new Time(codigo, nome, estadio, fundacao, estado);

            if (timeDAO.inserirTime(time)) {
                response.status(201); // 201 Created
                return "<mensagem>Time cadastrado com código: " + codigo + "</mensagem>";
            } else {
                response.status(500);
                return "<erro>Falha ao cadastrar time</erro>";
            }
        } catch (Exception e) {
            response.status(400); // Bad Request
            return "<erro>Dados inválidos</erro>";
        }
    }

    // BUSCAR TIME POR ID (GET)
    public Object get(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        Time[] times = timeDAO.getTimes();

        for (Time t : times) {
            if (t.getCodigo() == id) {
                response.type("application/xml");
                return "<time>\n" +
                       "   <codigo>" + t.getCodigo() + "</codigo>\n" +
                       "   <nome>" + t.getNome() + "</nome>\n" +
                       "   <estadio>" + t.getEstadio() + "</estadio>\n" +
                       "   <fundacao>" + t.getFundacao() + "</fundacao>\n" +
                       "   <estado>" + t.getEstado() + "</estado>\n" +
                       "</time>";
            }
        }

        response.status(404);
        return "<erro>Time não encontrado</erro>";
    }

    // ATUALIZAR TIME (POST)
    public Object update(Request request, Response response) {
        try {
            // Obtém os parâmetros do formulário
            int codigo = Integer.parseInt(request.queryParams("codigo"));
            String nome = request.queryParams("nome");
            String estadio = request.queryParams("estadio");
            int fundacao = Integer.parseInt(request.queryParams("fundacao"));
            String estado = request.queryParams("estado");

            // Validação básica dos parâmetros
            if (nome == null || nome.isEmpty() || 
                estadio == null || estadio.isEmpty() || 
                estado == null || estado.isEmpty()) {
                response.status(400);
                return "Todos os campos são obrigatórios!";
            }

            // Cria o objeto Time
            Time time = new Time(codigo, nome, estadio, fundacao, estado);
            
            // Chama o DAO para atualizar
            if (timeDAO.atualizarTime(time)) {
                response.status(200);
                return "Time atualizado com sucesso! ID: " + codigo;
            } else {
                response.status(404);
                return "Time com ID " + codigo + " não encontrado!";
            }
            
        } catch (NumberFormatException e) {
            response.status(400);
            return "ID inválido! Deve ser um número.";
        } catch (Exception e) {
            response.status(500);
            return "Erro ao atualizar time: " + e.getMessage();
        }
    }

    // REMOVER TIME (GET)
    public Object remove(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));

        if (timeDAO.excluirTime(id)) {
            return "<mensagem>Time removido com código: " + id + "</mensagem>";
        } else {
            response.status(404);
            return "<erro>Time não encontrado</erro>";
        }
    }

    // LISTAR TODOS OS TIMES (GET)
    public Object getAll(Request request, Response response) {
        Time[] times = timeDAO.getTimes();
        StringBuilder xml = new StringBuilder("<times>\n");

        for (Time t : times) {
            xml.append("   <time>\n")
               .append("       <codigo>").append(t.getCodigo()).append("</codigo>\n")
               .append("       <nome>").append(t.getNome()).append("</nome>\n")
               .append("       <estadio>").append(t.getEstadio()).append("</estadio>\n")
               .append("       <fundacao>").append(t.getFundacao()).append("</fundacao>\n")
               .append("       <estado>").append(t.getEstado()).append("</estado>\n")
               .append("   </time>\n");
        }

        xml.append("</times>");
        response.type("application/xml");
        return xml.toString();
    }
}
