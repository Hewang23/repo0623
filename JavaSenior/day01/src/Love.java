/**
 * @author Hewang
 * @create 2020-05-20 22:05
 * @title
 */
public class Love {
    public static void main(String[] args){
       Love love=new Love();
       love.love();
    }
    public void love(){
        int love=0;
        int day=1;
        int count=0;
        while(love<=365){
            love+=day;
            if(love==365){
                love=0;
                System.out.println("又是有你在的一年");
                count++;
            }
            if(count==80){
                break;
            }
        }
        System.out.println("这就是有你在的一生");
    }
}
