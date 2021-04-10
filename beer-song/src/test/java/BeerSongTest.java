class BeerSong{

    public String sing(int startverse,int num){
        int beer=startverse;
        String lyric ="";
        for(int i=0;i<num;i++){
            if(beer==0) return lyric+"No more bottles of beer on the wall, no more bottles of beer.\n" +
            "Go to the store and buy some more, 99 bottles of beer on the wall.\n\n";
            String nowbeer=(beer==1) ? "1 bottle" : beer+" bottles";
            String remaining=(beer==1) ? "no more bottles" : 
                            (beer==2) ? "1 bottle" :
                            beer-1+" bottles";
            String one =(beer==1) ?"it":"one";
            lyric+=nowbeer+" of beer on the wall, "+nowbeer+" of beer.\n" +
            "Take "+one+" down and pass it around, "+remaining+" of beer on the wall.\n\n";
            beer--;
        }
        return lyric;
        }

        public String singSong(){
            return sing(99, 100);
        }
}
