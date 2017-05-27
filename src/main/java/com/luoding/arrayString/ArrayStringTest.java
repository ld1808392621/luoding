package com.luoding.arrayString;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Date：16-7-4
 * Time：下午4:07
 *
 * @author ding.luo@corp.luoding .com
 */
public class ArrayStringTest {

    public static void main(String[] args){

        List<String> strs = new ArrayList<String>();
        strs.add("luoding");
        strs.add("luoding1");
        Gson gson = new Gson();

        String tempStr = "[]";
        List<String> strings = gson.fromJson(tempStr,List.class);
        System.out.println(strings.size());

        String str = "4497:true,6775:false,4491:false,6205:false,6870:false,6869:false,7357:false,7358:false,7351:false,6866:false,6865:false,1976:true,5642:false,1977:true,7160:false,7350:false,7212:false,6616:false,6617:false,4219:false,6217:false,6218:false,6885:false,3092:false,3:false,7071:false,7070:false,7073:false,7072:false,7340:false,7075:false,1984:false,7074:false,1985:false,7077:false,4221:true,7200:false,7078:false,7203:false,7204:false,7201:false,7202:false,4227:true,7228:false,7227:false,7229:false,6891:false,6892:false,6086:false,6087:false,6895:false,6896:false,6893:false,6894:false,6379:false,1704:false,6888:false,1705:false,7040:false,6887:false,7186:false,6886:false,7333:false,6749:false,7236:false,6748:false,6747:false,7185:false,7230:false,7184:false,7231:true,6479:false,6070:false,7219:false,4239:false,6078:false,7319:false,7320:false,7198:false,7321:true,7197:false,7199:false,6899:false,7324:false,6480:false,7225:false,7226:false,7223:false,7224:false,618:false,7221:false,6487:false,6755:false,7222:false,7196:false,7220:false,6488:false,4855:false,4854:false,4853:true,7249:false,4757:false,7253:false,7252:false,4557:false,7255:false,7254:false,7257:false,7256:false,7258:false,2997:false,2108:false,7251:true,2990:false,4257:false,7244:false,7243:false,7242:false,7241:false,4267:false,7248:false,7246:false,4458:false,7245:false,2112:false,4356:false,7240:false,4333:false,6797:false,6796:false,4735:true,1607:true,6795:false,1608:true,6988:false,1605:true,6987:false,1606:true,1603:true,6986:false,6985:false,1604:true,7279:false,6789:false,5015:false,7083:false,7081:false,7082:false,7080:false,4341:true,7359:false,857:true,6999:false,4722:false,6998:true,7361:false,6798:false,7360:false,6799:false,7264:false,7263:false,7262:false,7365:false,7261:false,7367:false,7366:false,4408:false,4405:false,4407:false,4406:false,284:true,6973:false,283:true,6972:false,4928:false,6969:false,4929:false,1010:true,7280:false,7281:false,7282:false,4419:false,6006:false,6155:false,6293:true,7286:false,6154:false,7287:false,6984:false,6156:false,6691:false,6692:false,6693:false,4836:false,6690:false,6182:false,6801:false,6800:false,6805:false,6951:false,6809:false,6950:false,4577:false,6945:false,6948:false,6682:false,6941:false,6683:false,6942:false,6680:false,6943:false,6681:false,6944:false,6949:false,6812:false,6816:false,6279:false,6278:false,6179:false,6818:false,6178:false,6817:false,6667:false,6956:true,6955:true,7021:false,6721:false,1935:false,1939:false,5681:true,6820:false,6515:false,6823:false,6928:false,6069:false,6920:false,3192:false,6060:false,6922:true,6063:true,6921:false,3190:true,6924:false,1563:true,6923:false,6926:false,6925:false,7034:false,7035:false,7032:false,7033:false,7038:false,6509:true,6940:false,7039:false,6839:false,6736:false,6737:false,6837:false,6838:false,6836:false,6256:true,6508:true,7030:false,1941:true,7031:false,7134:false,7311:false,5689:false,6939:false,6057:false,5595:false,5596:true,7004:true,7005:false,7006:false,7000:false,1691:false,6242:false,1693:true,5661:false,1692:false,5660:false,665:true,6848:false,6043:false,5658:false,1689:false,6906:false,5656:false,6905:false,5657:false,5654:false,6908:false,5655:false,6907:false,6902:false,6641:false,6903:false,6900:false,6040:false,7014:false,6628:true,7013:false,6625:false,6856:false,7159:false,6859:false,7157:true,6857:false,6719:false,7158:true,6858:false,5670:false,6034:false,6033:false,6919:false,6918:false,5473:false,6720:false,258:false,257:false,254:false,7007:false,255:true";

        System.out.println(str.split(",").length);

    }
}
