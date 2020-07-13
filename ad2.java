import javax.swing.*;

public class ad2{

    public static Pessoa(){
        String nome;
    }

    public static void main(String[] args) {
        List<String> listaDadosList=new ArrayList<String>();
        int op=0;
        while (op<=2) {
            switch(op){
                case 0:
                    op=Integer.parseInt(JOptionPane.showInputDialog(" Bem vindo, qual operação desejada? \n 1-Registar um ou mais entrevistados \n 2-Ler dados salvos"));
                break;
                
                case 1:

                    int n=Integer.parseInt(JOptionPane.showInputDialog("Quantos entrevistados a serem registrados?"));
                    for(int i=0;i<n;i++){
                        
                        String[] etniaValues ={"Branco", "Indígena", "Negro", "Pardo"};
                        Object etniaSelected = JOptionPane.showInputDialog(null, "Etnia:", "Selection", JOptionPane.DEFAULT_OPTION, null, values, "0");
                        
                        String[] idadeValues = {"Até 18 anos", "18-25", "26-36", "37-49", "50 ou mais"};
                        Object idadeSelected = JOptionPane.showInputDialog(null, "Faixa etária:", "Selection", JOptionPane.DEFAULT_OPTION, null, values, "0");
                        
                        String[] escolaridadeValues = {"Fundamental incompleto", "Medio incompleto", "Superior incompleto", "Superior completo"};
                        Object escolaridadeSelected = JOptionPane.showInputDialog(null, "Grau de escolaridade:", "Selection", JOptionPane.DEFAULT_OPTION, null, values, "0");

                        String[] sexoValues  = {"Feminino", "Masculino"};
                        Object sexoSelected = JOptionPane.showInputDialog(null, "Grau de escolaridade:", "Selection", JOptionPane.DEFAULT_OPTION, null, values, "0");

                        String[] orientacaoValues = {"Heterossexual", "Homossexual", "Bissexual", "Prefiro não informar"};
                        Object orientacaoSelected = JOptionPane.showInputDialog(null, "Orientação sexual:", "Selection", JOptionPane.DEFAULT_OPTION, null, values, "0");

                        String[] rendaValues =  {"Um salário minimo", "1000-1500", "1500-2000", "Mais de 2000"};
                        Object rendaSelected = JOptionPane.showInputDialog(null, "Renda estimada:", "Selection", JOptionPane.DEFAULT_OPTION, null, values, "0");


                        //faz pra pessoa
                        listaDadosList.add(service.getRegistrarWSPort().registrarDados(etnia, sexo, idade, escolaridade, orientacao, renda));
                    }
                break;
                
                case 2:
                    //metodo pra fornecer o relatorio de porcentagens
                break;
            }
            
        }
    }
}