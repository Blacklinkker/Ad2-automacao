import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class ad2 {
    //Lista armazenando os registrados
    public static List<Pessoa> listaDados = new ArrayList<Pessoa>();

    public static void main(String[] args) {
        int op = 0;
        //Menu principal
        while (op != 5) {
            switch (op) {
                case 0:
                    op = Integer.parseInt(JOptionPane.showInputDialog("Bem vindo, qual operação desejada? \n"
                    +"1 - Registar um ou mais entrevistados \n"
                    +"2 - Ler dados salvos \n"
                    +"3 - Estatisticas \n"
                    +"4 - Sair"));
                break;

                case 1:
                    registrar();
                    op=0;
                break;
                
                case 2:
                    if(listaDados.size()!=0){
                        exibe();
                    }else{
                        JOptionPane.showMessageDialog(null, "Erro: Não há registros, retornando ao menu!", "Erro", JOptionPane.ERROR_MESSAGE);               
                    }
                    op=0;
                        
                break;

                case 3:
                    if(listaDados.size() != 0){
                        int op2=Integer.parseInt(JOptionPane.showInputDialog("informe estatística desejada: \n"
                        +"1 - Renda \n"
                        +"2 - Etnia \n"
                        +"3 - Sexo \n"
                        +"4 - Escolaridade \n"
                        +"5 - Faixa etária \n"
                        +"6 - Orientação \n"
                        +"7 - Emprego \n"
                        +"8 - Deficiência \n"));
                        exibeEstatistica(op2);
                    }else{
                        JOptionPane.showMessageDialog(null, "Erro: Não há registros, retornando ao menu!", "Erro", JOptionPane.ERROR_MESSAGE);                        
                    }
                    op=0;
                break;

                case 4:
                    op=5;
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


            x = JOptionPane.showOptionDialog(null, "Ao aceitar, seus dados serão armazenados e utilizados para estatisticas anônimas, estarão disponiveis para organizações que desejem prestar auxilio","Atenção", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            
            if(x == 0){
                String nome = JOptionPane.showInputDialog("Nome do entrevistado: ");

                x = JOptionPane.showOptionDialog(null, "Possui cpf:?", "ATENÇÃO", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                int cpf = 0;

                if (x == 0) {
                    cpf = Integer.parseInt(JOptionPane.showInputDialog("CPF: "));
                } else {
                    possuiCpf = false;
                }

                //Menus drop-down para selecionar valores, minizando possibilidade de erros por parte do usuário
                String[] rendaValues = { "Não possui", "Até um salário minimo", "1000-1500", "1500-2000", "Mais de 2000" };
                Object rendaSelected = JOptionPane.showInputDialog(null, "Renda estimada:", "Selecione uma opção", JOptionPane.DEFAULT_OPTION, null, rendaValues, "0");

                String[] etniaValues = { "Branco", "Indígena", "Negro", "Pardo", "Asiático" };
                Object etniaSelected = JOptionPane.showInputDialog(null, "Etnia:", "Selecione uma opção", JOptionPane.DEFAULT_OPTION, null, etniaValues, "0");
                
                String[] sexoValues = { "Feminino", "Masculino" };
                Object sexoSelected = JOptionPane.showInputDialog(null, "Sexo:", "Selecione uma opção", JOptionPane.DEFAULT_OPTION, null, sexoValues, "0");
                
                String[] escolaridadeValues = { "Não possui escolaridade", "Fundamental incompleto", "Medio incompleto", "Superior incompleto", "Superior completo" };
                Object escolaridadeSelected = JOptionPane.showInputDialog(null, "Grau de escolaridade:", "Selecione uma opção", JOptionPane.DEFAULT_OPTION, null, escolaridadeValues, "0");
                
                String[] idadeValues = { "Até 18 anos", "18-25", "26-36", "37-49", "50-60", "61 ou mais"};
                Object idadeSelected = JOptionPane.showInputDialog(null, "Faixa etária:", "Selecione uma opção", JOptionPane.DEFAULT_OPTION, null, idadeValues, "0");

                String[] orientacaoValues = { "Heterossexual", "Homossexual", "Bissexual", "Prefiro não informar" };
                Object orientacaoSelected = JOptionPane.showInputDialog(null, "Orientação sexual:", "Selecione uma opção", JOptionPane.DEFAULT_OPTION, null, orientacaoValues, "0");

                String[] empregoValues = { "Não possui", "Emprego fixo", "Não-CLT"};
                Object empregoSelected = JOptionPane.showInputDialog(null, "Situação laboral: ", "Selecione uma opção", JOptionPane.DEFAULT_OPTION, null, empregoValues, "0");

                x = JOptionPane.showOptionDialog(null, "Possui deficiência?:", "ATENÇÃO", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                Object deficienciaSelected = null;

                if (x == 0) {
                    possuiDeficiencia = true;
                    String[] deficiencia = { "Física", "Mental", "Visual", "Auditiva", "Multipla" };
                    deficienciaSelected = JOptionPane.showInputDialog(null, "Qual?", "Selecione uma opção", JOptionPane.DEFAULT_OPTION, null, deficiencia, "0");
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
            }else{
                JOptionPane.showMessageDialog(null, "Erro: Para continuar, aceite os termos de uso!", "Erro", JOptionPane.ERROR_MESSAGE);
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

    //metodo que gera relatorio de estatistica sobre dado selecionado
    public static void exibeEstatistica(int op2){
    
        switch(op2){
            case 1:
                String[] rendaValues = { "Não possui", "Até um salário minimo", "1000-1500", "1500-2000", "Mais de 2000" };
                Object rendaSelected = JOptionPane.showInputDialog(null, "Renda estimada:", "Selecione uma opção", JOptionPane.DEFAULT_OPTION, null, rendaValues, "0");
                
                JOptionPane.showMessageDialog(null, Relatorio.rendaCount(rendaSelected.toString(), listaDados));
            break;

            case 2:
                String[] etniaValues = { "Branco", "Indígena", "Negro", "Pardo", "Asiático" };
                Object etniaSelected = JOptionPane.showInputDialog(null, "Etnia:", "Selecione uma opção", JOptionPane.DEFAULT_OPTION, null, etniaValues, "0");

                JOptionPane.showMessageDialog(null, Relatorio.etniaCount(etniaSelected.toString(), listaDados));               
            break;

            case 3:
                String[] sexoValues = { "Feminino", "Masculino" };
                Object sexoSelected = JOptionPane.showInputDialog(null, "Grau de escolaridade:", "Selecione uma opção", JOptionPane.DEFAULT_OPTION, null, sexoValues, "0");

                JOptionPane.showMessageDialog(null, Relatorio.sexoCount(sexoSelected.toString(), listaDados));
            break;

            case 4:
                String[] escolaridadeValues = { "Não possui escolaridade", "Fundamental incompleto", "Medio incompleto", "Superior incompleto", "Superior completo" };
                Object escolaridadeSelected = JOptionPane.showInputDialog(null, "Grau de escolaridade:", "Selecione uma opção", JOptionPane.DEFAULT_OPTION, null, escolaridadeValues, "0");

                JOptionPane.showMessageDialog(null, Relatorio.escolaridadeCount(escolaridadeSelected.toString(), listaDados));
            break;

            case 5:
                String[] idadeValues = { "Até 18 anos", "18-25", "26-36", "37-49", "50-60", "61 ou mais"};
                Object idadeSelected = JOptionPane.showInputDialog(null, "Faixa etária:", "Selecione uma opção", JOptionPane.DEFAULT_OPTION, null, idadeValues, "0");

                JOptionPane.showMessageDialog(null, Relatorio.idadeCount(idadeSelected.toString(), listaDados));
            break;

            case 6:
                String[] orientacaoValues = { "Heterossexual", "Homossexual", "Bissexual", "Prefiro não informar" };
                Object orientacaoSelected = JOptionPane.showInputDialog(null, "Orientação sexual:", "Selecione uma opção", JOptionPane.DEFAULT_OPTION, null, orientacaoValues, "0");
                
                JOptionPane.showMessageDialog(null, Relatorio.orientacaoCount(orientacaoSelected.toString(), listaDados));
            break;

            case 7:    
                String[] empregoValues = { "Não possui", "Emprego fixo", "Não-CLT"};
                Object empregoSelected = JOptionPane.showInputDialog(null, "Situação laboral: ", "Selecione uma opção", JOptionPane.DEFAULT_OPTION, null, empregoValues, "0");

                JOptionPane.showMessageDialog(null, Relatorio.empregoCount(empregoSelected.toString(), listaDados));
            break;

            case 8:
                String[] deficiencia = { "Física", "Mental", "Visual", "Auditiva", "Multipla" };
                Object deficienciaSelected = JOptionPane.showInputDialog(null, "Qual?", "Selecione uma opção", JOptionPane.DEFAULT_OPTION, null, deficiencia, "0");
                
                JOptionPane.showMessageDialog(null, Relatorio.deficienciaCount(deficienciaSelected.toString(), listaDados));
            break;   
        }
    }   
}
