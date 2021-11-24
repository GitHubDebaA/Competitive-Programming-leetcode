// Exam Room; complete: n
// date: 17.11.2021

class Main {
    public static void main(String[] args) {
        String operation[] = {"ExamRoom","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave"};
        int values[][] = {{1000000000},{},{0},{},{0},{},{0},{},{0},{},{0}};

        ExamRoom obj = new ExamRoom(values[0][0]);
        int j = 0;
        for(String op: operation) {
            if(op.equals("ExamRoom")) {
                obj = new ExamRoom(values[j][0]);
                j += 1;
            }
            else if(op.equals("seat")) {
                System.out.println(obj.seat());
                j += 1;
            }
            else if(op.equals("leave")) {
                obj.leave(values[j][0]);
                j += 1;
            }
        }
    }
}

class ExamRoom {
    boolean classRoom[];
    int numberofStudent, n;
    public ExamRoom(int n) {
        classRoom = new boolean [n];
        numberofStudent = 0;
        this.n = n;
    }

    public int seat() {

        if(numberofStudent == 0) {
            classRoom[0] = true;
            numberofStudent += 1;
            return 0;
        }

        else if(numberofStudent == 1) {
            int loc = 0, i; 
            for(i=0; i<classRoom.length; i++) {
                if(classRoom[i] == true) break;
             }

            if(i == 0) loc = n-1;
            else if(i == n-1) loc = 0;
            else {
                int len1 = i - 0;
                int len2 = n-i+1;
                loc = 0;
                if(len2 > len1) loc = n-1;
            }
            classRoom[loc] = true;
            numberofStudent += 1;
            return loc;
        }   
        else {
            int mid = 0, diff, tempmid = 0, i, j, loc = 0;

            i = 0;
            while(i < n) {
                j = i + 1;
                while(j < n) {
                    if(classRoom[j] == true) break;
                    j += 1;
                }
                if(i == 0 && classRoom[0] == false) {
                    tempmid = j-i;
                }
                else if(j == n && classRoom[n-1] == false) {
                    tempmid = n-i-1;
                }
                else {
                    diff = j-i;
                    tempmid = diff/2;
                }

                if(tempmid > mid) {
                    mid = tempmid;
                    loc = i;
                }
                i = j;
            }

            numberofStudent += 1;

            // System.out.println("loc : "+loc+"\tmid: "+mid);

            if((loc == 0 && classRoom[loc] == false) || (loc == n-1 && classRoom[loc] == false)) {
                classRoom[loc] = true;
                return loc;
            }
            else {
                classRoom[mid+loc] = true;
                return mid+loc;
            }
        }
    }

    public void leave(int p) {
        if(classRoom[p] == true) {
            classRoom[p] = false;
            numberofStudent -= 1;
            System.out.println("Valid Leave");

        }
        else System.out.println("Invalid Leave");
    }
}

/*
test case-116
["ExamRoom","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave"]
[[1000000000],[],[0],[],[0],[],[0],[],[0],[],[0]]

test case-120
["ExamRoom","seat","seat","seat","leave","leave","seat","seat","seat","seat","seat","seat","seat"]
[[8],[],[],[],[0],[7],[],[],[],[],[],[],[]]

Expected: [null,0,7,3,null,null,7,0,5,1,2,4,6]

                0 1 2 3 4 5 6 7
    classRoom = 0 0 0 0 0 0 0 0        position
                1 0 0 0 0 0 0 0 (seat) 0
                1 0 0 0 0 0 0 1 (seat) 1
                1 0 0 1 0 0 0 1 (seat) 3
                0 0 0 1 0 0 0 1 (leave 0)
                0 0 0 1 0 0 0 0 (leave 7)
                0 0 0 1 0 0 0 1 (seat) 7
                1 0 0 1 0 0 0 1 (seat) 0
                1 0 0 1 0 1 0 1 (seat) 5
                1 1 0 1 0 1 0 1 (seat) 1
                1 1 1 1 0 1 0 1 (seat) 2
                1 1 1 1 1 1 0 1 (seat) 4
                1 1 1 1 1 1 1 1 (seat) 6

    
test case- 
["ExamRoom","seat","seat","seat","seat","leave","leave","seat"]
[[4],[],[],[],[],[1],[3],[]]
                0 1 2 3
    classRoom = 0 0 0 0         position
                1 0 0 0 (seat)  0
                1 0 0 1 (seat)  3
                1 1 0 1 (seat)  1
                1 1 1 1 (seat)  2
                1 0 1 1 (leave 1)
                1 0 1 0 (leave 3)
                1 1 1 1 (seat)  1

test case- 96
["ExamRoom","seat","seat","seat","leave","leave","seat","seat","seat","seat","seat","seat","seat","seat","seat","leave"]
[[10],[],[],[],[0],[4],[],[],[],[],[],[],[],[],[],[0]]

                0 1 2 3 4 5 6 7 8 9
    classRoom = 0 0 0 0 0 0 0 0 0 0         position
                1 0 0 0 0 0 0 0 0 0 (seat)  0
                1 0 0 0 0 0 0 0 0 1 (seat)  9
                1 0 0 0 1 0 0 0 0 1 (seat)  4
                0 0 0 0 1 0 0 0 0 1 (leave 0)
                0 0 0 0 0 0 0 0 0 1 (leave 4)
                1 0 0 0 0 0 0 0 0 1 (seat)  0
                1 0 0 0 1 0 0 0 0 1 (seat)  4
                1 0 1 0 1 0 0 0 0 1 (seat)  2
                1 0 1 0 1 0 1 0 0 1 (seat)  6
                1 1 1 0 1 0 1 0 0 1 (seat)  1
                1 1 1 1 1 0 1 0 0 1 (seat)  3
                1 1 1 1 1 1 1 0 0 1 (seat)  5
                1 1 1 1 1 1 1 1 0 1 (seat)  7
                1 1 1 1 1 1 1 1 1 1 (seat)  8
                0 1 1 1 1 1 1 1 1 1 (leave 0)


test case - 99
["ExamRoom","seat","seat","seat","leave","leave","seat","seat","seat","seat","seat","seat","seat","seat","seat","leave","leave","seat","seat","leave","seat","leave","seat","leave","seat","leave","seat","leave","leave","seat","seat","leave","leave","seat","seat","leave"]
[[10],[],[],[],[0],[4],[],[],[],[],[],[],[],[],[],[0],[4],[],[],[7],[],[3],[],[3],[],[9],[],[0],[8],[],[],[0],[8],[],[],[2]]

                0 1 2 3 4 5 6 7 8 9
    classRoom = 0 0 0 0 0 0 0 0 0 0         position
                1 0 0 0 0 0 0 0 0 0 (seat)  0
                1 0 0 0 0 0 0 0 0 1 (seat)  9
                1 0 0 0 1 0 0 0 0 1 (seat)  4
                0 0 0 0 1 0 0 0 0 1 (leave 0)
                0 0 0 0 0 0 0 0 0 1 (leave 4)
                1 0 0 0 0 0 0 0 0 1 (seat)  0
                1 0 0 0 1 0 0 0 0 1 (seat)  4
                1 0 1 0 1 0 0 0 0 1 (seat)  2
                1 0 1 0 1 0 1 0 0 1 (seat)  6
                1 1 1 0 1 0 1 0 0 1 (seat)  1
                1 1 1 1 1 0 1 0 0 1 (seat)  3
                1 1 1 1 1 1 1 0 0 1 (seat)  5
                1 1 1 1 1 1 1 1 0 1 (seat)  7
                1 1 1 1 1 1 1 1 1 1 (seat)  8
                0 1 1 1 1 1 1 1 1 1 (leave 0)
                0 1 1 1 0 1 1 1 1 1 (leave 4)
                1 1 1 1 0 1 1 1 1 1 (seat) 0
                1 1 1 1 1 1 1 1 1 1 (seat) 4
                1 1 1 1 1 1 1 0 1 1 (leave 7)
                1 1 1 1 1 1 1 1 1 1 (seat) 7
                1 1 1 0 1 1 1 1 1 1 (leave 3)
                1 1 1 1 1 1 1 1 1 1 (seat) 3
                1 1 1 0 1 1 1 1 1 1 (leave 3)
                1 1 1 1 1 1 1 1 1 1 (seat) 3
                1 1 1 1 1 1 1 1 1 0 (leave 9)
                1 1 1 1 1 1 1 1 1 1 (seat) 9
                0 1 1 1 1 1 1 1 1 1 (leave 0)
                0 1 1 1 1 1 1 1 0 1 (leave 8)
                1 1 1 1 1 1 1 1 0 1 (seat) 0
                1 1 1 1 1 1 1 1 1 1 (seat) 8
                0 1 1 1 1 1 1 1 1 1 (leave 0)
                0 1 1 1 1 1 1 1 0 1 (leave 8)
                1 1 1 1 1 1 1 1 0 1 (seat) 0
                1 1 1 1 1 1 1 1 1 1 (seat) 8               
                1 1 0 1 1 1 1 1 1 1 (leave 2)               
*/