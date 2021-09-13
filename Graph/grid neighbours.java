int dr[] = {0,0,1,-1}
int dc[] = {1,-1,0,0}
for(int i=0;i<4;i++){
  rr = row + dr[i];
  cc = col + dc[i];
  if(rr < 0 || cc < 0 || rr > totalrows || cc > totalcols) continue;
  //(rr,cc) is a neighbour of (row,col)
}
