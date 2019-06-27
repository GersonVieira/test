package com.example.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Gravador {
    //"comentario"
    public void gravarArquivo(String nomeArquivo, String texto, Context ctx){
        try{
            FileOutputStream arquivo=ctx.openFileOutput(nomeArquivo,Context.MODE_PRIVATE);
            arquivo.write(texto.getBytes());
            arquivo.close();
        }catch(FileNotFoundException erro){
            System.out.println("erro gravando1 =" +erro.getMessage());
        }catch(IOException erro){
            System.out.println("erro gravando2 =" +erro.getMessage());
        }
    }

    public String lerArquivo(String nomeArquivo, Context ctx){
        String texto2="";
        try{

            FileInputStream arquivo2=ctx.openFileInput(nomeArquivo);
            int texto=arquivo2.read();
            while(texto!=-1){
                char c=(char) texto;
                texto2+=c;
                texto=arquivo2.read();
            }
            arquivo2.close();
        }catch(FileNotFoundException erro){
            System.out.println("Erro 1");

        }catch(IOException erro){
            System.out.println("Erro 2");
        }
        return texto2;
    }

    public void salvarAluno(Aluno a,Context ctx){
        String s="";
        s+=a.getNome()+"|";
        s+=a.getCidade()+"|";
        s+=a.getPontuacao()+"|";
        gravarArquivo("Aluno.txt",s, ctx);
    }
    public Aluno lerAluno(Context ctx){
        Aluno a=new Aluno();
        String arquivo=lerArquivo("Aluno.txt",ctx);
        Scanner scan=new Scanner(arquivo).useDelimiter("\\|");
        System.out.println(arquivo);
        a.setNome(scan.next());
        a.setCidade(scan.next());
        a.setPontuacao(Integer.parseInt(scan.next()));
        scan.close();


        return a;
    }
    public void salvarQuestao(String nomeArquivo, Questao questao,Context context){
        gravarArquivo(nomeArquivo,questao.toStringSave(),context);
    }
    public Questao lerQuestao(String nomeArquivo, Context context){

        String arquivo = lerArquivo(nomeArquivo, context);
        Scanner sc=new Scanner(arquivo).useDelimiter("\\|");
        Alternativa a1=new Alternativa(Boolean.parseBoolean(sc.next()),sc.next(),sc.next());
        Alternativa a2=new Alternativa(Boolean.parseBoolean(sc.next()),sc.next(),sc.next());
        Alternativa a3=new Alternativa(Boolean.parseBoolean(sc.next()),sc.next(),sc.next());
        Alternativa a4=new Alternativa(Boolean.parseBoolean(sc.next()),sc.next(),sc.next());
        Alternativa a5=new Alternativa(Boolean.parseBoolean(sc.next()),sc.next(),sc.next());
        String dica=sc.next();
        String dificuldade=sc.next();
        String enunciado=sc.next();
        int nivel=Integer.parseInt(sc.next());
        int valor=Integer.parseInt(sc.next());
        String tema=sc.next();
        Questao questao=new Questao(a1,a2,a3,a4,a5,dica,dificuldade,enunciado,nivel,valor,tema);
        sc.close();
        return  questao;
    }
    public boolean isDataCorreta(Context context){
        Date data=new Date();
        SimpleDateFormat dateFormat;
        dateFormat=new SimpleDateFormat("ddMMyyyy");
        String dataLida=lerArquivo("Data.txt",context);
        String dataAtual=dateFormat.format(data).toString();
        if(dataLida.length()<6){
            gravarArquivo("Data.txt",dataAtual,context);
            System.out.println("Rodou aqui kkkkkk");
            return false;
        }
        int diaAtual, diaArquivo,mesAtual,mesArquivo, anoAtual, anoArquivo;
        diaArquivo=Integer.parseInt(dataLida.substring(0,2));
        mesArquivo=Integer.parseInt(dataLida.substring(2,4));
        anoArquivo=Integer.parseInt(dataLida.substring(4,6));
        diaAtual=Integer.parseInt(dataAtual.substring(0,2));
        mesAtual=Integer.parseInt(dataAtual.substring(2,4));
        anoAtual=Integer.parseInt(dataAtual.substring(4,6));
        if(anoAtual>anoArquivo){
            return true;
        }else if(mesAtual>mesArquivo){
            return true;
        }else if(diaAtual>diaArquivo){
            return true;
        }
        System.out.println("Agora rodou esse kkkkkkkk");
        return false;

    }
    public List<Questao> lerQuestoesGeff(String nomeArquivo, Context context){
        List<Questao> questoes = new ArrayList<Questao>();
        String arquivo = lerArquivo(nomeArquivo, context);
        Scanner sc=new Scanner(arquivo).useDelimiter("\\|");
        int cont=0;
        while(sc.hasNext()){
            Alternativa a1=new Alternativa(Boolean.parseBoolean(sc.next()),sc.next(),sc.next());
            Alternativa a2=new Alternativa(Boolean.parseBoolean(sc.next()),sc.next(),sc.next());
            Alternativa a3=new Alternativa(Boolean.parseBoolean(sc.next()),sc.next(),sc.next());
            Alternativa a4=new Alternativa(Boolean.parseBoolean(sc.next()),sc.next(),sc.next());
            Alternativa a5=new Alternativa(Boolean.parseBoolean(sc.next()),sc.next(),sc.next());
            String dica=sc.next();
            String dificuldade=sc.next();
            String enunciado=sc.next();
            int nivel=Integer.parseInt(sc.next());
            int valor=Integer.parseInt(sc.next());
            String tema=sc.next();
            Questao questao=new Questao(a1,a2,a3,a4,a5,dica,dificuldade,enunciado,nivel,valor,tema);
            questoes.add(questao);
        }
        sc.close();
        return  questoes;
    }


}
