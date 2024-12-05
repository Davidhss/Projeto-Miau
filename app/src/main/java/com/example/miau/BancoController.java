package com.example.miau;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {
        private SQLiteDatabase db;
        private CriaBanco banco;

        public BancoController(Context context) {
            banco = new CriaBanco(context);
        }

        // Inserir dados na tabela Genero
        public String insereGenero(String descricao) {
            ContentValues valores = new ContentValues();
            valores.put("descricao", descricao);

            db = banco.getWritableDatabase();
            long resultado = db.insert("Genero", null, valores);
            db.close();

            if (resultado == -1)
                return "Erro ao inserir registro";
            else
                return "Registro inserido com sucesso";
        }

        // Inserir dados na tabela Usuario
        public String insereUsuario(String nome, String email, String senha, String dataNasc, int codGenero, String cpf, String img) {
            ContentValues valores = new ContentValues();
            valores.put("nome", nome);
            valores.put("email", email);
            valores.put("senha", senha);
            valores.put("data_nasc", dataNasc);
            valores.put("cod_genero", codGenero);
            valores.put("cpf", cpf);
            valores.put("img", img);

            db = banco.getWritableDatabase();
            long resultado = db.insert("Usuario", null, valores);
            db.close();

            if (resultado == -1)
                return "Erro ao inserir registro";
            else
                return "Registro inserido com sucesso";
        }

        // Carregar dados do Usuario pelo ID
        public Cursor carregaUsuarioPeloId(int id) {
            Cursor cursor;
            String[] campos = { "id", "nome", "email", "senha", "data_nasc", "cod_genero", "cpf", "img" };
            String where = "id=" + id;

            db = banco.getReadableDatabase();
            cursor = db.query("Usuario", campos, where, null, null, null, null, null);

            if (cursor != null) {
                cursor.moveToFirst();
            }

            db.close();
            return cursor;
        }

        // Alterar dados de um Usuario
        public String alteraUsuario(int id, String nome, String email, String senha, String dataNasc, int codGenero, String cpf, String img) {
            String msg = "Dados alterados com sucesso!";

            db = banco.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put("nome", nome);
            valores.put("email", email);
            valores.put("senha", senha);
            valores.put("data_nasc", dataNasc);
            valores.put("cod_genero", codGenero);
            valores.put("cpf", cpf);
            valores.put("img", img);

            String condicao = "id = " + id;

            int linhas = db.update("Usuario", valores, condicao, null);

            if (linhas < 1) {
                msg = "Erro ao alterar os dados";
            }

            db.close();
            return msg;
        }

        // Excluir dados de um Usuario
        public String excluirUsuario(int id) {
            String msg = "Registro excluído";

            db = banco.getWritableDatabase();

            String condicao = "id = " + id;

            int linhas = db.delete("Usuario", condicao, null);

            if (linhas < 1) {
                msg = "Erro ao excluir";
            }

            db.close();
            return msg;
        }

        // Inserir dados na tabela Raca
        public String insereRaca(String descricao) {
            ContentValues valores = new ContentValues();
            valores.put("descricao", descricao);

            db = banco.getWritableDatabase();
            long resultado = db.insert("Raca", null, valores);
            db.close();

            if (resultado == -1)
                return "Erro ao inserir registro";
            else
                return "Registro inserido com sucesso";
        }

        // Inserir dados na tabela Pet
        public String inserePet(String nome, int codRaca, int codGenero, int castracao, int codTipo, float peso, String dataNasc, String img, int codUsu) {
            ContentValues valores = new ContentValues();
            valores.put("nome", nome);
            valores.put("cod_raca", codRaca);
            valores.put("cod_genero", codGenero);
            valores.put("castracao", castracao);
            valores.put("cod_tipo", codTipo);
            valores.put("peso", peso);
            valores.put("data_nasc", dataNasc);
            valores.put("img", img);
            valores.put("cod_usu", codUsu);

            db = banco.getWritableDatabase();
            long resultado = db.insert("Pet", null, valores);
            db.close();

            if (resultado == -1)
                return "Erro ao inserir registro";
            else
                return "Registro inserido com sucesso";
        }

        // Carregar dados do Pet pelo ID
        public Cursor carregaPetPeloId(int id) {
            Cursor cursor;
            String[] campos = { "id", "nome", "cod_raca", "cod_genero", "castracao", "cod_tipo", "peso", "data_nasc", "img", "cod_usu" };
            String where = "id=" + id;

            db = banco.getReadableDatabase();
            cursor = db.query("Pet", campos, where, null, null, null, null, null);

            if (cursor != null) {
                cursor.moveToFirst();
            }

            db.close();
            return cursor;
        }

        // Alterar dados de um Pet
        public String alteraPet(int id, String nome, int codRaca, int codGenero, int castracao, int codTipo, float peso, String dataNasc, String img, int codUsu) {
            String msg = "Dados alterados com sucesso!";

            db = banco.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put("nome", nome);
            valores.put("cod_raca", codRaca);
            valores.put("cod_genero", codGenero);
            valores.put("castracao", castracao);
            valores.put("cod_tipo", codTipo);
            valores.put("peso", peso);
            valores.put("data_nasc", dataNasc);
            valores.put("img", img);
            valores.put("cod_usu", codUsu);

            String condicao = "id = " + id;

            int linhas = db.update("Pet", valores, condicao, null);

            if (linhas < 1) {
                msg = "Erro ao alterar os dados";
            }

            db.close();
            return msg;
        }

        // Excluir dados de um Pet
        public String excluirPet(int id) {
            String msg = "Registro excluído";

            db = banco.getWritableDatabase();

            String condicao = "id = " + id;

            int linhas = db.delete("Pet", condicao, null);

            if (linhas < 1) {
                msg = "Erro ao excluir";
            }

            db.close();
            return msg;
        }

        // Inserir dados na tabela Servicos
        public String insereServico(String nome, String descricao) {
            ContentValues valores = new ContentValues();
            valores.put("nome", nome);
            valores.put("descricao", descricao);

            db = banco.getWritableDatabase();
            long resultado = db.insert("Servicos", null, valores);
            db.close();

            if (resultado == -1)
                return "Erro ao inserir registro";
            else
                return "Registro inserido com sucesso";
        }

    // Inserir dados na tabela Agendamento
    public String insereAgendamento(String descricao, String dtAgendamento, String horario, int codUsu, int codPet, int codServico) {
        ContentValues valores = new ContentValues();
        valores.put("descricao", descricao);
        valores.put("dt_agendamento", dtAgendamento);
        valores.put("horario", horario);
        valores.put("cod_usu", codUsu);
        valores.put("cod_pet", codPet);
        valores.put("cod_servico", codServico);

        db = banco.getWritableDatabase();
        long resultado = db.insert("Agendamento", null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";
    }

    // Carregar dados do Agendamento pelo ID
    public Cursor carregaAgendamentoPeloId(int id) {
        Cursor cursor;
        String[] campos = { "id", "descricao", "dt_agendamento", "horario", "cod_usu", "cod_pet", "cod_servico" };
        String where = "id=" + id;

        db = banco.getReadableDatabase();
        cursor = db.query("Agendamento", campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    // Alterar dados de um Agendamento
    public String alteraAgendamento(int id, String descricao, String dtAgendamento, String horario, int codUsu, int codPet, int codServico) {
        String msg = "Dados alterados com sucesso!";

        db = banco.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("descricao", descricao);
        valores.put("dt_agendamento", dtAgendamento);
        valores.put("horario", horario);
        valores.put("cod_usu", codUsu);
        valores.put("cod_pet", codPet);
        valores.put("cod_servico", codServico);

        String condicao = "id = " + id;

        int linhas = db.update("Agendamento", valores, condicao, null);

        if (linhas < 1) {
            msg = "Erro ao alterar os dados";
        }

        db.close();
        return msg;
    }

    // Excluir dados de um Agendamento
    public String excluirAgendamento(int id) {
        String msg = "Registro excluído";

        db = banco.getWritableDatabase();

        String condicao = "id = " + id;

        int linhas = db.delete("Agendamento", condicao, null);

        if (linhas < 1) {
            msg = "Erro ao excluir";
        }

        db.close();
        return msg;
    }

    // Inserir dados na tabela Categoria_Produto
    public String insereCategoriaProduto(String descricao) {
        ContentValues valores = new ContentValues();
        valores.put("descricao", descricao);

        db = banco.getWritableDatabase();
        long resultado = db.insert("Categoria_Produto", null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";
    }

    // Inserir dados na tabela Produto
    public String insereProduto(String nome, String descricao, float preco, String img, int codCat) {
        ContentValues valores = new ContentValues();
        valores.put("nome", nome);
        valores.put("descricao", descricao);
        valores.put("preco", preco);
        valores.put("img", img);
        valores.put("cod_cat", codCat);

        db = banco.getWritableDatabase();
        long resultado = db.insert("Produto", null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";
    }

    // Carregar dados do Produto pelo ID
    public Cursor carregaProdutoPeloId(int id) {
        Cursor cursor;
        String[] campos = { "id", "nome", "descricao", "preco", "img", "cod_cat" };
        String where = "id=" + id;

        db = banco.getReadableDatabase();
        cursor = db.query("Produto", campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    // Alterar dados de um Produto
    public String alteraProduto(int id, String nome, String descricao, float preco, String img, int codCat) {
        String msg = "Dados alterados com sucesso!";

        db = banco.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nome", nome);
        valores.put("descricao", descricao);
        valores.put("preco", preco);
        valores.put("img", img);
        valores.put("cod_cat", codCat);

        String condicao = "id = " + id;

        int linhas = db.update("Produto", valores, condicao, null);

        if (linhas < 1) {
            msg = "Erro ao alterar os dados";
        }

        db.close();
        return msg;
    }

    // Excluir dados de um Produto
    public String excluirProduto(int id) {
        String msg = "Registro excluído";

        db = banco.getWritableDatabase();

        String condicao = "id = " + id;

        int linhas = db.delete("Produto", condicao, null);

        if (linhas < 1) {
            msg = "Erro ao excluir";
        }

        db.close();
        return msg;
    }

    // Inserir dados na tabela Pedido
    public String inserePedido(int codNota, int codProd, int qtde, float valorFinal) {
        ContentValues valores = new ContentValues();
        valores.put("cod_nota", codNota);
        valores.put("cod_prod", codProd);
        valores.put("qtde", qtde);
        valores.put("valor_final", valorFinal);

        db = banco.getWritableDatabase();
        long resultado = db.insert("Pedido", null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";
    }

    // Inserir dados na tabela Nota_Fiscal
    public String insereNotaFiscal(int codUsu, int codPgto, String dataNota, float valor) {
        ContentValues valores = new ContentValues();
        valores.put("cod_usu", codUsu);
        valores.put("cod_pgto", codPgto);
        valores.put("data_nota", dataNota);
        valores.put("valor", valor);

        db = banco.getWritableDatabase();
        long resultado = db.insert("Nota_Fiscal", null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";
    }

    // Inserir dados na tabela F_Pgto
    public String insereFPgto(String nome) {
        ContentValues valores = new ContentValues();
        valores.put("nome", nome);

        db = banco.getWritableDatabase();
        long resultado = db.insert("F_Pgto", null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro inserido com sucesso";
    }

    }
