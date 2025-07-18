
import java.util.ArrayList;
/**
 * ADT  ที่เก็บ Integer แบบไม่ซ้ำกันและเรียงลำดับ
 */

public class IntegerSet  {
    ArrayList<Integer> Numbers;

    // Rep Invariant (RI):
    //  - Numbers must not contain duplicate Integre.
    //  - Integer in Numbers must be sorted in ascending order.
    //
    // Abstraction Function (AF):
    //  - AF( Numbers ) = the set of Integeer in the string Numbers.

    // Constructor เริ่มต้น สร้างเซตว่าง
    public IntegerSet(){
        Numbers = new ArrayList<>();
        CheckRep() ;

    }
    
    //ตรวจสอบว่า Rep Invariant เป็นจริงหรือไม่
    private void CheckRep(){
        if (Numbers == null)
            throw new RuntimeException("Number is null");
        if(Numbers.size()>1){
            for(int i = 0 ; i < Numbers.size() - 1 ; i++){
                if(Numbers.get(i) >= Numbers.get(i+1))
                 throw new RuntimeException("Rep invariant violated!");
            }
            
        }

    }
    
    /**
     * เพิ่มตัวเลขเข้าเซต
     * @param x
     * ตัวเลขที่ต้องการเพิ่ม
     */

    public void add(Integer x){
        
        if (!Numbers.contains(x) && Numbers != null && x != null) {
            if(Numbers.size() == 0){
                Numbers.add(x) ;
            } else {    
                if (x < Numbers.get(0)) { // add หน้าสุด
                        Numbers.add(0,x);
                } else { 
                    for (int i = 0 ; i < Numbers.size() ; i++){
                        if (i == Numbers.size() - 1) { // add หลังสุด
                            Numbers.add(x) ;
                            break ;
                            }
                        if (Numbers.get(i) < x && x < Numbers.get(i+1)) { // add ตรงกลาง
                            Numbers.add(i+1,x);
                            break;
                        }
                    }
                }
            }
        }
        CheckRep();
    }

    /**
     * ลบตัวเลขออกจากเซต
     * @param x
     * ตัวเลขที่ต้องการลบ
     */
    public void remove(Integer x) {
        Numbers.remove(x);
        CheckRep();
    }
    /**
     * ตรวจสอบว่ามีตัวอักษรนี้อยู่ในเซตหรือไม่
     * @param x ตัวอักษรที่ต้องการตรวจสอบ
     * @return true หากมี x อยู่ในเซต, false หากไม่มี
     */

    public boolean contains(Integer x) {
        return Numbers.contains(x);
    }

    /**
     * คืนค่าขนาดของเซต
     * @return จำนวนสมาชิกในเซต
     */
    public int size() {
        return Numbers.size();
    }
    
    @Override
    public String toString(){
        return Numbers.toString();
    }
}
