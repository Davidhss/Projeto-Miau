package com.example.miau;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "projetomiau.db";
    private static final int VERSAO = 1;
    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tabela Genero
        String sqlGenero = "CREATE TABLE Genero ("
                + "id INTEGER PRIMARY KEY,"
                + "descricao TEXT)";
        db.execSQL(sqlGenero);

        // Tabela Usuario
        String sqlUsuario = "CREATE TABLE Usuario ("
                + "id INTEGER PRIMARY KEY,"
                + "nome TEXT,"
                + "email TEXT,"
                + "senha TEXT,"
                + "data_nasc DATE,"
                + "cod_genero INTEGER,"
                + "cpf TEXT,"
                + "img TEXT,"
                + "FOREIGN KEY (cod_genero) REFERENCES Genero(id))";
        db.execSQL(sqlUsuario);

        // Tabela Notificacao
        String sqlNotificacao = "CREATE TABLE Notificacao ("
                + "id INTEGER PRIMARY KEY,"
                + "mensagem TEXT,"
                + "cod_usu INTEGER,"
                + "FOREIGN KEY (cod_usu) REFERENCES Usuario(id))";
        db.execSQL(sqlNotificacao);

        // Tabela Raca
        String sqlRaca = "CREATE TABLE Raca ("
                + "id INTEGER PRIMARY KEY,"
                + "descricao TEXT)";
        db.execSQL(sqlRaca);

        // Tabela Tipo_Animal
        String sqlTipoAnimal = "CREATE TABLE Tipo_Animal ("
                + "id INTEGER PRIMARY KEY,"
                + "descricao TEXT)";
        db.execSQL(sqlTipoAnimal);

        // Tabela Pet
        String sqlPet = "CREATE TABLE Pet ("
                + "id INTEGER PRIMARY KEY,"
                + "nome TEXT,"
                + "cod_raca INTEGER,"
                + "cod_genero INTEGER,"
                + "castracao INTEGER,"
                + "cod_tipo INTEGER,"
                + "peso REAL,"
                + "data_nasc DATE,"
                + "img TEXT,"
                + "cod_usu INTEGER,"
                + "FOREIGN KEY (cod_raca) REFERENCES Raca(id),"
                + "FOREIGN KEY (cod_genero) REFERENCES Genero(id),"
                + "FOREIGN KEY (cod_tipo) REFERENCES Tipo_Animal(id),"
                + "FOREIGN KEY (cod_usu) REFERENCES Usuario(id))";
        db.execSQL(sqlPet);

        // Tabela Servicos
        String sqlServicos = "CREATE TABLE Servicos ("
                + "id INTEGER PRIMARY KEY,"
                + "nome TEXT,"
                + "descricao TEXT)";
        db.execSQL(sqlServicos);

        // Tabela Agendamento
        String sqlAgendamento = "CREATE TABLE Agendamento ("
                + "id INTEGER PRIMARY KEY,"
                + "descricao TEXT,"
                + "dt_agendamento DATE,"
                + "horario TIME,"
                + "cod_usu INTEGER,"
                + "cod_pet INTEGER,"
                + "cod_servico INTEGER,"
                + "FOREIGN KEY (cod_usu) REFERENCES Usuario(id),"
                + "FOREIGN KEY (cod_pet) REFERENCES Pet(id),"
                + "FOREIGN KEY (cod_servico) REFERENCES Servicos(id))";
        db.execSQL(sqlAgendamento);

        // Tabela Categoria_Produto
        String sqlCategoriaProduto = "CREATE TABLE Categoria_Produto ("
                + "id INTEGER PRIMARY KEY,"
                + "descricao TEXT)";
        db.execSQL(sqlCategoriaProduto);

        // Tabela Produto
        String sqlProduto = "CREATE TABLE Produto ("
                + "id INTEGER PRIMARY KEY,"
                + "nome TEXT,"
                + "descricao TEXT,"
                + "preco REAL,"
                + "img TEXT,"
                + "cod_cat INTEGER,"
                + "FOREIGN KEY (cod_cat) REFERENCES Categoria_Produto(id))";
        db.execSQL(sqlProduto);

        // Tabela Pedido
        String sqlPedido = "CREATE TABLE Pedido ("
                + "id INTEGER PRIMARY KEY,"
                + "cod_nota INTEGER,"
                + "cod_prod INTEGER,"
                + "qtde INTEGER,"
                + "valor_final REAL,"
                + "FOREIGN KEY (cod_prod) REFERENCES Produto(id))";
        db.execSQL(sqlPedido);

        // Tabela Nota_Fiscal
        String sqlNotaFiscal = "CREATE TABLE Nota_Fiscal ("
                + "id INTEGER PRIMARY KEY,"
                + "cod_usu INTEGER,"
                + "cod_pgto INTEGER,"
                + "data_nota DATE,"
                + "valor REAL,"
                + "FOREIGN KEY (cod_usu) REFERENCES Usuario(id))";
        db.execSQL(sqlNotaFiscal);

        // Tabela F_Pgto
        String sqlFPgto = "CREATE TABLE F_Pgto ("
                + "id INTEGER PRIMARY KEY,"
                + "nome TEXT)";
        db.execSQL(sqlFPgto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contatos");
        onCreate(db);
    }
}

