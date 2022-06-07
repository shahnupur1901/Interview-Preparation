    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        
        ArrayList<Meeting> meets = new ArrayList();
        for(int i=0;i<n;i++){
            meets.add(new Meeting(start[i], end[i], i));
        }
        Collections.sort(meets, new Comparator<Meeting>(){
            public int compare(Meeting m1, Meeting m2){
                if(m1.end < m2.end) return -1;
                if(m1.end == m2.end) return m1.idx < m2.idx ? -1 : 1;
                return 1;
            }
        });
        int count = 0, previous_end = 0;
        for(Meeting m : meets){
             // System.out.println(m.start +" "+m.end);
            if(m.start > previous_end){
               // System.out.println(m.start +" "+previous_end);
                count ++;
                previous_end = m.end;
            }
        }
        return count;
    }
