import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class ad2 {
    //Lista armazenando os registrados
    public static List<Pessoa> listaDados = new ArrayList<Pessoa>();

    public static void main(String[] args) {
        int op = 0;
        //Menu principal
        while (op != 4) {
            switch (op) {
                case 0:
                    op = Integer.parseInt(JOptionPane.showInputDialog("Bem vindo, qual operação desejada? \n"
                    +"1-Registar um ou mais entrevistados \n"
                    +"2-Ler dados salvos \n"
                    +"3-Sair"));
                break;

                case 1:
                    registrar();
                    op=0;
                break;
                
                case 2:
                    if(listaDados.size()!=0){
                        exibe();
                    }else{
                        JOptionPane.showMessageDialog(null, "Erro: Não há registros, retornando ao menu!", "Erro", JOptionPane.ERROR_MESSAGE);                        }
                        op=0;
                break;

                case 3:
                    op=4;
                break;

                default:
                    JOptionPane.showMessageDialog(null, "Erro: Entrada inválida, retornando ao menu!", "Erro", JOptionPane.ERROR_MESSAGE);
                    op=0;
            }
        }
    }

    //Metodo de registro
    public static void registrar() {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Quantos entrevistados a serem registrados: "));

        for (int i = 0; i < n; i++) {
            boolean possuiDeficiencia = false;
            boolean possuiCpf = true;
            String[] options = { "Sim", "Não" };
            int x;

            String nome = JOptionPane.showInputDialog("Nome do entrevistado: ");

            x = JOptionPane.showOptionDialog(null, "Possui cpf:?", "ATENÇÃO", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            int cpf = 0;

            if (x == 0) {
                cpf = Integer.parseInt(JOptionPane.showInputDialog("CPF: "));
            } else {
                possuiCpf = false;
            }

            String[] etniaValues = { "Branco", "Indígena", "Negro", "Pardo", "Asiático" };
            Object etniaSelected = JOptionPane.showInputDialog(null, "Etnia:", "Selection", JOptionPane.DEFAULT_OPTION, null, etniaValues, "0");

            String[] idadeValues = { "Até 18 anos", "18-25", "26-36", "37-49", "50-60", "61 ou mais"};
            Object idadeSelected = JOptionPane.showInputDialog(null, "Faixa etária:", "Selection", JOptionPane.DEFAULT_OPTION, null, idadeValues, "0");

            String[] escolaridadeValues = { "Não possui escolaridade", "Fundamental incompleto", "Medio incompleto", "Superior incompleto", "Superior completo" };
            Object escolaridadeSelected = JOptionPane.showInputDialog(null, "Grau de escolaridade:", "Selection", JOptionPane.DEFAULT_OPTION, null, escolaridadeValues, "0");

            String[] sexoValues = { "Feminino", "Masculino" };
            Object sexoSelected = JOptionPane.showInputDialog(null, "Grau de escolaridade:", "Selection", JOptionPane.DEFAULT_OPTION, null, sexoValues, "0");

            String[] orientacaoValues = { "Heterossexual", "Homossexual", "Bissexual", "Prefiro não informar" };
            Object orientacaoSelected = JOptionPane.showInputDialog(null, "Orientação sexual:", "Selection", JOptionPane.DEFAULT_OPTION, null, orientacaoValues, "0");

            String[] rendaValues = { "Não possui", "Até um salário minimo", "1000-1500", "1500-2000", "Mais de 2000" };
            Object rendaSelected = JOptionPane.showInputDialog(null, "Renda estimada:", "Selection", JOptionPane.DEFAULT_OPTION, null, rendaValues, "0");

            String[] empregoValues = { "Não possui", "Emprego fixo", "Não-CLT"};
            Object empregoSelected = JOptionPane.showInputDialog(null, "Situação laboral: ", "Selection", JOptionPane.DEFAULT_OPTION, null, empregoValues, "0");

            x = JOptionPane.showOptionDialog(null, "Possui deficiência?:", "ATENÇÃO", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            Object deficienciaSelected = null;

            if (x == 0) {
                possuiDeficiencia = true;
                String[] deficiencia = { "Física", "Mental", "Visual", "Auditiva", "Multipla" };
                deficienciaSelected = JOptionPane.showInputDialog(null, "Qual?", "Selection", JOptionPane.DEFAULT_OPTION, null, deficiencia, "0");
            }

            if (possuiCpf && possuiDeficiencia) {
                listaDados.add(new Pessoa(nome, etniaSelected.toString(), sexoSelected.toString(), escolaridadeSelected.toString(), idadeSelected.toString(), orientacaoSelected.toString(), rendaSelected.toString(), cpf, deficienciaSelected.toString(), empregoSelected.toString()));

            } else if (possuiCpf && !possuiDeficiencia) {
                listaDados.add(new Pessoa(nome, etniaSelected.toString(), sexoSelected.toString(), escolaridadeSelected.toString(), idadeSelected.toString(), orientacaoSelected.toString(), rendaSelected.toString(), cpf, empregoSelected.toString()));

            } else if (!possuiCpf && possuiDeficiencia) {
                listaDados.add(new Pessoa(nome, etniaSelected.toString(), sexoSelected.toString(), escolaridadeSelected.toString(), idadeSelected.toString(), orientacaoSelected.toString(), rendaSelected.toString(), deficienciaSelected.toString(), empregoSelected.toString()));

            } else {
                listaDados.add(new Pessoa(nome, etniaSelected.toString(), sexoSelected.toString(), escolaridadeSelected.toString(), idadeSelected.toString(), orientacaoSelected.toString(), rendaSelected.toString(), empregoSelected.toString()));
            }
        }
    }

    //Metodo para exebir todos os registrados
    public static void exibe() {
        String toString= "============================ \n";
        
        for (Pessoa pessoa : listaDados) {
           toString+= pessoa.toString() + "\n___________________________";
        }

        JOptionPane.showMessageDialog(null, toString, "Registrados", JOptionPane.INFORMATION_MESSAGE);
    }
}
