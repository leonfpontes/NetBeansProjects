package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroDAO {
    Livro livro = new Livro();
    private Connection con = ConnectionFactory.getConnection();
    String sql = "sp_CadastraLocacao(?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement preparestatement = con.prepareStatement(sql)) {
        preparestatement.setDouble(1, livro.getVnCodLivro()); //substitui o ? pelo dado do usuario
    }catch (SQLException e){
        e.printStackTrace();
    }
}
