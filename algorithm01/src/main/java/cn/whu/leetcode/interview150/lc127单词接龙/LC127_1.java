package cn.whu.leetcode.interview150.lc127单词接龙;

import cn.whu.utils.HzaUtils;
import cn.whu.utils.ListNode;
import cn.whu.utils.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LC127_1 extends Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        cache.clear();
        visited.clear();
        int ans = dfs(beginWord, endWord, wordList, new ArrayList<>());
        return ans == MAX ? 0 : ans;
    }

    HashSet<String> visited = new HashSet<>();
    HashMap<String, Integer> cache = new HashMap<>();
    public static final int MAX = 5002; // Integer.MAX_VALUE 不行，容易越界变小 ★

    // begin--end 要走多少步
    public int dfs(String begin, String end, List<String> wordList, List<String> path) {
        if (cache.containsKey(begin)) return cache.get(begin);
        if (begin.equals(end)) {
            //print(path);
            print(visited);
            cache.put(begin, 1);
            return 1;
        }
        //if (k > wordList.size() + 1) return;
        //prints(k, begin, wordList.size());
        int ans = MAX;
        for (String s : wordList) {
            if (!visited.contains(s) && siNext(s, begin)) {
                visited.add(s);
                ans = Math.min(ans, dfs(s, end, wordList, path) + 1);
                //prints(begin, ans, k);
                visited.remove(s);//一次只能走一步
            }
        }
        cache.put(begin, ans);
        return cache.get(begin);
    }


    public boolean siNext(String str1, String str2) {
        int d = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) d++;
            if (d > 1) break;
        }
        return d == 1;
    }


    public static void main(String[] args) {
        test("hit", "cog", "[hot,dot,dog,lot,log,cog]");
        test("hit", "cog", "[hot,dot,dog,lot,log]");
        test("qa", "sq", "[[si,go,se,cm,so,ph,mt,db,mb,sb,kr,ln,tm,le,av,sm,ar,ci,ca,br,ti,ba,to,ra,fa,yo,ow,sn,ya,cr,po,fe,ho,ma,re,or,rn,au,ur,rh,sr,tc,lt,lo,as,fr,nb,yb,if,pb,ge,th,pm,rb,sh,co,ga,li,ha,hz,no,bi,di,hi,qa,pi,os,uh,wm,an,me,mo,na,la,st,er,sc,ne,mn,mi,am,ex,pt,io,be,fm,ta,tb,ni,mr,pa,he,lr,sq,ye]]");
        test("cet", "ism", "[kid,tag,pup,ail,tun,woo,erg,luz,brr,gay,sip,kay,per,val,mes,ohs,now,boa,cet,pal,bar,die,war,hay,eco,pub,lob,rue,fry,lit,rex,jan,cot,bid,ali,pay,col,gum,ger,row,won,dan,rum,fad,tut,sag,yip,sui,ark,has,zip,fez,own,ump,dis,ads,max,jaw,out,btu,ana,gap,cry,led,abe,box,ore,pig,fie,toy,fat,cal,lie,noh,sew,ono,tam,flu,mgm,ply,awe,pry,tit,tie,yet,too,tax,jim,san,pan,map,ski,ova,wed,non,wac,nut,why,bye,lye,oct,old,fin,feb,chi,sap,owl,log,tod,dot,bow,fob,for,joe,ivy,fan,age,fax,hip,jib,mel,hus,sob,ifs,tab,ara,dab,jag,jar,arm,lot,tom,sax,tex,yum,pei,wen,wry,ire,irk,far,mew,wit,doe,gas,rte,ian,pot,ask,wag,hag,amy,nag,ron,soy,gin,don,tug,fay,vic,boo,nam,ave,buy,sop,but,orb,fen,paw,his,sub,bob,yea,oft,inn,rod,yam,pew,web,hod,hun,gyp,wei,wis,rob,gad,pie,mon,dog,bib,rub,ere,dig,era,cat,fox,bee,mod,day,apr,vie,nev,jam,pam,new,aye,ani,and,ibm,yap,can,pyx,tar,kin,fog,hum,pip,cup,dye,lyx,jog,nun,par,wan,fey,bus,oak,bad,ats,set,qom,vat,eat,pus,rev,axe,ion,six,ila,lao,mom,mas,pro,few,opt,poe,art,ash,oar,cap,lop,may,shy,rid,bat,sum,rim,fee,bmw,sky,maj,hue,thy,ava,rap,den,fla,auk,cox,ibo,hey,saw,vim,sec,ltd,you,its,tat,dew,eva,tog,ram,let,see,zit,maw,nix,ate,gig,rep,owe,ind,hog,eve,sam,zoo,any,dow,cod,bed,vet,ham,sis,hex,via,fir,nod,mao,aug,mum,hoe,bah,hal,keg,hew,zed,tow,gog,ass,dem,who,bet,gos,son,ear,spy,kit,boy,due,sen,oaf,mix,hep,fur,ada,bin,nil,mia,ewe,hit,fix,sad,rib,eye,hop,haw,wax,mid,tad,ken,wad,rye,pap,bog,gut,ito,woe,our,ado,sin,mad,ray,hon,roy,dip,hen,iva,lug,asp,hui,yak,bay,poi,yep,bun,try,lad,elm,nat,wyo,gym,dug,toe,dee,wig,sly,rip,geo,cog,pas,zen,odd,nan,lay,pod,fit,hem,joy,bum,rio,yon,dec,leg,put,sue,dim,pet,yaw,nub,bit,bur,sid,sun,oil,red,doc,moe,caw,eel,dix,cub,end,gem,off,yew,hug,pop,tub,sgt,lid,pun,ton,sol,din,yup,jab,pea,bug,gag,mil,jig,hub,low,did,tin,get,gte,sox,lei,mig,fig,lon,use,ban,flo,nov,jut,bag,mir,sty,lap,two,ins,con,ant,net,tux,ode,stu,mug,cad,nap,gun,fop,tot,sow,sal,sic,ted,wot,del,imp,cob,way,ann,tan,mci,job,wet,ism,err,him,all,pad,hah,hie,aim,ike,jed,ego,mac,baa,min,com,ill,was,cab,ago,ina,big,ilk,gal,tap,duh,ola,ran,lab,top,gob,hot,ora,tia,kip,han,met,hut,she,sac,fed,goo,tee,ell,not,act,gil,rut,ala,ape,rig,cid,god,duo,lin,aid,gel,awl,lag,elf,liz,ref,aha,fib,oho,tho,her,nor,ace,adz,fun,ned,coo,win,tao,coy,van,man,pit,guy,foe,hid,mai,sup,jay,hob,mow,jot,are,pol,arc,lax,aft,alb,len,air,pug,pox,vow,got,meg,zoe,amp,ale,bud,gee,pin,dun,pat,ten,mob]");

        //beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]

    }

    private static void test(String beginWord, String endWord, String str) {
        List<String> wordList = HzaUtils.string2List(str);

        //print(wordList);

        LC127_1 t = new LC127_1();
        int ans = t.ladderLength(beginWord, endWord, wordList);
        print(ans);
    }

}
