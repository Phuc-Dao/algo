1. if sidx == s.length() && pidx >= p.length()
2. if(pidx == p.length()) return false;
3. if(sidx == s.length() && pidx == p.length() - 1 && p.charAt(pidx + 1) == '*') return helper(s,p, sidx, pidx + 2);
4. if (sidx == s.length()) return false;
5. if(pidx == p.length() - 1 && s.charAt(sidx) == s.charAt(pidx)) return helper(s,p, sidx + 1, pidx + 1); 6. first = p.charAt(pidx); second = p.charAt(second); if(second == '*'){ if(first == '.' || s.charAt(sidx) == first ){ return helper() || helper(); } else{ return helper(); }
}
else{
    if(first == '.' || s.charAt(sidx) == first){
        return helper(s,p, sidx + 1, pidx + 1);
    }
    else{
        return false;
    }
}

aa
a

aa
a*

abba
.*

aabc
a*b*c*

..*a






