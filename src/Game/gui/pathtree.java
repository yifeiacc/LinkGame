package Game.gui;

import java.io.*;
import java.util.*;

/**
 * Created by yifei on 16/10/12.
 */

// Data structure to store 50,000 solutions of IQ-game
public class pathtree {
    private String path;
    private HashMap<String,pathtree> children = new HashMap<>();
    private int depth;
    pathtree(String path,int depth){
        this.depth =depth;
        this.path =path;

    }
    public void add(String str){
        if(this.depth <12){
            String str1 = str.substring(0,(this.depth+1)*3);
            if(this.children.get(str1) == null){
                children.put(str1,new pathtree(str1,this.depth+1));
                children.get(str1).add(str);
            }else{
                children.get(str1).add(str);
            }
        }

    }
    // helper method to decide if a placement has one solution.
    private boolean isOneSolNode(){
        if(this.depth<12){
            if(this.children.size()>1){
                return false;
                }
            for(Map.Entry<String,pathtree> c :this.children.entrySet()){
                return c.getValue().isOneSolNode();
            }

        }
        return true;
    }
    // find all one solution placement from 50,000 placement data set
    public void findOneSol(HashMap<Integer,List<String>> result){
        if(this.depth < 12){

            if(this.isOneSolNode()){
                if(result.containsKey(this.depth)){
                    result.get(this.depth).add(this.path);
                }else{
                    result.put(this.depth,new ArrayList<String>());
                    result.get(this.depth).add(this.path);
                }


            }else{
                for(Map.Entry<String,pathtree> c :children.entrySet()){
                    c.getValue().findOneSol(result);


                }

            }

        }


    }

    public static void main(String[] args) {
        pathtree a = new pathtree("root",0);
        String pathname = "solutions.txt";
        File filename = new File(pathname);
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            while (line != null) {
                List<String> L = new ArrayList<>();
                for(int i =0; i<12;i++){
                    L.add(line.substring(i*3,i*3+3));
                }
                Collections.sort(L,(String x,String y)->{  // order solutions
                    if(x.charAt(1)-y.charAt(1)>=0){
                        return 1;
                    }else return-1;
                });
                String result="";
                for(String c : L){
                    result = result+c;
                }
                a.add(result);
                line = br.readLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        HashMap<Integer,List<String>> result = new HashMap<>();
        a.findOneSol(result);
        String str ="";
        try {
            PrintStream output = new PrintStream(new FileOutputStream("OneSolutionTable.txt")); //output all one solution  placement
            for(Map.Entry<Integer,List<String>> item : result.entrySet()){
                str = item.getKey()+item.getValue().toString();
                output.println(str);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println(a.children.get("BAA").children.get("BAAHBA").children);
    }
}
