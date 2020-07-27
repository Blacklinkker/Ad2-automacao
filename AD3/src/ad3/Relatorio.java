/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad3;
import java.util.List;

public class Relatorio {
    //Metodos utilizados para as estatisticas
    public static String rendaCount(String parametroBusca, List<Pessoa> listaDados){
        int contador=0;
        for (Pessoa pessoa : listaDados) {
            if(pessoa.renda == parametroBusca ){
                contador++;
            }
        }
        return "Porcentagem de entrevistados que se enquadram nessa faixa de renda: \n" + ((contador / listaDados.size())*100)+" %";
    }

    public static String etniaCount(String parametroBusca, List<Pessoa> listaDados){
        int contador=0;
        for (Pessoa pessoa : listaDados) {
            if(pessoa.etnia == parametroBusca ){
                contador++;
            }
        }
        return "Porcentagem de entrevistados que se enquadram nessa etnia: \n" + ((contador / listaDados.size())*100)+" %";
    }

    
    public static String sexoCount(String parametroBusca, List<Pessoa> listaDados){
        int contador=0;
        for (Pessoa pessoa : listaDados) {
            if(pessoa.sexo == parametroBusca ){
                contador++;
            }
        }
        return "Porcentagem de entrevistados que se enquadram nesse sexo: \n" + ((contador / listaDados.size())*100)+" %";
    }

    public static String escolaridadeCount(String parametroBusca, List<Pessoa> listaDados){
        int contador=0;
        for (Pessoa pessoa : listaDados) {
            if(pessoa.escolaridade == parametroBusca ){
                contador++;
            }
        }
        return "Porcentagem de entrevistados que se enquadram nesse grau de escolaridade: \n" + ((contador / listaDados.size())*100)+" %";
    }

    public static String idadeCount(String parametroBusca, List<Pessoa> listaDados){
        int contador=0;
        for (Pessoa pessoa : listaDados) {
            if(pessoa.idade == parametroBusca ){
                contador++;
            }
        }
        return "Porcentagem de entrevistados que se enquadram nessa faixa etária: \n" + ((contador / listaDados.size())*100)+" %";
    }

    public static String orientacaoCount(String parametroBusca, List<Pessoa> listaDados){
        int contador=0;
        for (Pessoa pessoa : listaDados) {
            if(pessoa.orientacao == parametroBusca ){
                contador++;
            }
        }
        return "Porcentagem de entrevistados que se enquadram nessa orientação: \n" + ((contador / listaDados.size())*100)+" %";
    }

    public static String empregoCount(String parametroBusca, List<Pessoa> listaDados){
        int contador=0;
        for (Pessoa pessoa : listaDados) {
            if(pessoa.emprego == parametroBusca ){
                contador++;
            }
        }
        return "Porcentagem de entrevistados que se enquadram nessa situação laboral: \n" + ((contador / listaDados.size())*100)+" %";
    }
    public static String deficienciaCount(String parametroBusca, List<Pessoa> listaDados){
        int contador=0;
        for (Pessoa pessoa : listaDados) {
            if(pessoa.deficiencia == parametroBusca ){
                contador++;
            }
        }
        return "Porcentagem de entrevistados que se enquadram nesse tipo de deficiência: \n" + ((contador / listaDados.size())*100)+" %";
    }
}