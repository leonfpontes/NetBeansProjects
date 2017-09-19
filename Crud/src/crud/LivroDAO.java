package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroDAO {
    Livro livro = new Livro();
    private Connection con = ConnectionFactory.getConnection();
    
    //MÉTODO PARA CADASTRAR LOCAÇÃO DO LIVRO
    public void cadastrarLocacao(){
        Interface inter = new Interface();
        String sql = "sp_CadastraLocacao(?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparestatement = con.prepareStatement(sql)){
            preparestatement.setDouble(1, livro.getVnCodLivro()); //substitui o ? pelo dado do usuario
            preparestatement.setInt(2, inter.getDfQtd()); 
            preparestatement.setInt(3, 1); //TODO CRIAR CAMPO PARA CÓDIGO DA PESSOA
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
}
