package src;

import java.util.ArrayList;

public class Memory {
    public static writeBack writeBack;
    public static String[] memory;
    public static int[] registerFile;
    public static String res;
    public static int clock;
    public static String ex;
    public void initialise(){
        res=null;
    }
    public static void memory(int result,ArrayList<String> s){
        System.out.println(result+" result of execute input " +s +" arraylist that contains decoded input -memory-");
        System.out.println(ex+" instruction -memory-");
        if(clock%2!=0){
            clock++;
        }
		String res=null;
        int r2;
        int x;
        int imm;
		
        switch(s.get(0)){
            case "1010"://LW
                        
                        res=memory[1024+result];
						
                        break;
            case "1011"://SW
						if(!s.get(3).equals("0zer0")){
                        int r=registerFile[Integer.parseInt(s.get(3))];
						memory[1024+result]=r+"";
                        System.out.println("Data portion Update: ");
                        for (int i=1024;i<memory.length;i++){
                           
                            System.out.print(memory[i]);
                            if (i==(1024 +result)){
                                System.out.print("  --> changed");
                            }
                            System.out.println();
                        }
                        res=null;
						}
						
						
                        break;
           



         }
         writeBack.ex=ex;
         System.out.println(clock+" -memory-");
         writeBack.clock=++clock;
         
         writeBack.writeBack(res,s);
        
        
    }
}
