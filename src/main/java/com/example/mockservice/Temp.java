package com.example.mockservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

class Location{
    private String id;
    private String address;
    private String city;
    private String zipCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
class Data{
    private String id;
    private String userId;
    private String userName;
    private String timestamp;
    private String txnType;
    private String amount;
    private Location location;
    private String ip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
public class Temp {
    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    static String json="{\"data\": [{\"id\": 2,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1549260902604,\"txnType\": \"debit\",\"amount\": \"$3,574.95\",\"location\": {\"id\": 8,\"address\": \"389, Everest, Barwell Terrace\",\"city\": \"Murillo\",\"zipCode\": 66061},\"ip\": \"212.215.115.165\"},{\"id\": 4,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1549272069586,\"txnType\": \"debit\",\"amount\": \"$0.87\",\"location\": {\"id\": 8,\"address\": \"389, Everest, Barwell Terrace\",\"city\": \"Murillo\",\"zipCode\": 66061},\"ip\": \"119.162.205.226\"},{\"id\": 10,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1552863189963,\"txnType\": \"debit\",\"amount\": \"$3,611.80\",\"location\": {\"id\": 1,\"address\": \"948, Entroflex, Franklin Avenue\",\"city\": \"Ilchester\",\"zipCode\": 84181},\"ip\": \"212.215.115.165\"},{\"id\": 18,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1550143522252,\"txnType\": \"debit\",\"amount\": \"$2,235.13\",\"location\": {\"id\": 1,\"address\": \"948, Entroflex, Franklin Avenue\",\"city\": \"Ilchester\",\"zipCode\": 84181},\"ip\": \"111.83.155.103\"},{\"id\": 19,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1552070436910,\"txnType\": \"credit\",\"amount\": \"$2,659.47\",\"location\": {\"id\": 6,\"address\": \"206, Portaline, Brooklyn Avenue\",\"city\": \"Brownlee\",\"zipCode\": 80358},\"ip\": \"212.215.115.165\"},{\"id\": 20,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1546523118910,\"txnType\": \"debit\",\"amount\": \"$1,543.25\",\"location\": {\"id\": 9,\"address\": \"961, Neptide, Elliott Walk\",\"city\": \"Bourg\",\"zipCode\": 68602},\"ip\": \"142.216.23.1\"},{\"id\": 24,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1546530515282,\"txnType\": \"debit\",\"amount\": \"$2,201.65\",\"location\": {\"id\": 6,\"address\": \"206, Portaline, Brooklyn Avenue\",\"city\": \"Brownlee\",\"zipCode\": 80358},\"ip\": \"142.216.23.1\"},{\"id\": 33,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1549507438915,\"txnType\": \"debit\",\"amount\": \"$2,898.16\",\"location\": {\"id\": 8,\"address\": \"389, Everest, Barwell Terrace\",\"city\": \"Murillo\",\"zipCode\": 66061},\"ip\": \"119.162.205.226\"},{\"id\": 42,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1548791324284,\"txnType\": \"credit\",\"amount\": \"$2,084.06\",\"location\": {\"id\": 6,\"address\": \"206, Portaline, Brooklyn Avenue\",\"city\": \"Brownlee\",\"zipCode\": 80358},\"ip\": \"142.216.23.1\"},{\"id\": 43,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1550842200606,\"txnType\": \"credit\",\"amount\": \"$3,844.66\",\"location\": {\"id\": 1,\"address\": \"948, Entroflex, Franklin Avenue\",\"city\": \"Ilchester\",\"zipCode\": 84181},\"ip\": \"212.215.115.165\"},{\"id\": 44,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1546401458604,\"txnType\": \"credit\",\"amount\": \"$1,134.12\",\"location\": {\"id\": 1,\"address\": \"948, Entroflex, Franklin Avenue\",\"city\": \"Ilchester\",\"zipCode\": 84181},\"ip\": \"142.216.23.1\"},{\"id\": 45,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1549247308734,\"txnType\": \"credit\",\"amount\": \"$514.70\",\"location\": {\"id\": 9,\"address\": \"961, Neptide, Elliott Walk\",\"city\": \"Bourg\",\"zipCode\": 68602},\"ip\": \"5.116.1.11\"},{\"id\": 52,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1550887247981,\"txnType\": \"debit\",\"amount\": \"$434.38\",\"location\": {\"id\": 1,\"address\": \"948, Entroflex, Franklin Avenue\",\"city\": \"Ilchester\",\"zipCode\": 84181},\"ip\": \"181.191.153.61\"},{\"id\": 55,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1550038422331,\"txnType\": \"credit\",\"amount\": \"$630.80\",\"location\": {\"id\": 1,\"address\": \"948, Entroflex, Franklin Avenue\",\"city\": \"Ilchester\",\"zipCode\": 84181},\"ip\": \"119.162.205.226\"},{\"id\": 63,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1547141971176,\"txnType\": \"debit\",\"amount\": \"$1,142.55\",\"location\": {\"id\": 1,\"address\": \"948, Entroflex, Franklin Avenue\",\"city\": \"Ilchester\",\"zipCode\": 84181},\"ip\": \"35.151.1.82\"},{\"id\": 68,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1547943352806,\"txnType\": \"debit\",\"amount\": \"$2,218.57\",\"location\": {\"id\": 8,\"address\": \"389, Everest, Barwell Terrace\",\"city\": \"Murillo\",\"zipCode\": 66061},\"ip\": \"35.151.1.82\"},{\"id\": 69,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1552245792882,\"txnType\": \"credit\",\"amount\": \"$1,073.47\",\"location\": {\"id\": 8,\"address\": \"389, Everest, Barwell Terrace\",\"city\": \"Murillo\",\"zipCode\": 66061},\"ip\": \"119.162.205.226\"},{\"id\": 74,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1546966983149,\"txnType\": \"credit\",\"amount\": \"$889.53\",\"location\": {\"id\": 9,\"address\": \"961, Neptide, Elliott Walk\",\"city\": \"Bourg\",\"zipCode\": 68602},\"ip\": \"181.191.153.61\"},{\"id\": 81,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1554000873959,\"txnType\": \"debit\",\"amount\": \"$3,568.55\",\"location\": {\"id\": 9,\"address\": \"961, Neptide, Elliott Walk\",\"city\": \"Bourg\",\"zipCode\": 68602},\"ip\": \"212.215.115.165\"},{\"id\": 82,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1546793876879,\"txnType\": \"credit\",\"amount\": \"$1,703.06\",\"location\": {\"id\": 9,\"address\": \"961, Neptide, Elliott Walk\",\"city\": \"Bourg\",\"zipCode\": 68602},\"ip\": \"35.151.1.82\"},{\"id\": 83,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1546606369803,\"txnType\": \"debit\",\"amount\": \"$2,551.34\",\"location\": {\"id\": 1,\"address\": \"948, Entroflex, Franklin Avenue\",\"city\": \"Ilchester\",\"zipCode\": 84181},\"ip\": \"142.216.23.1\"},{\"id\": 84,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1546369438369,\"txnType\": \"credit\",\"amount\": \"$2,615.48\",\"location\": {\"id\": 6,\"address\": \"206, Portaline, Brooklyn Avenue\",\"city\": \"Brownlee\",\"zipCode\": 80358},\"ip\": \"5.116.1.11\"},{\"id\": 91,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1549474339557,\"txnType\": \"credit\",\"amount\": \"$652.81\",\"location\": {\"id\": 9,\"address\": \"961, Neptide, Elliott Walk\",\"city\": \"Bourg\",\"zipCode\": 68602},\"ip\": \"119.162.205.226\"},{\"id\": 92,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1552834351584,\"txnType\": \"credit\",\"amount\": \"$595.51\",\"location\": {\"id\": 1,\"address\": \"948, Entroflex, Franklin Avenue\",\"city\": \"Ilchester\",\"zipCode\": 84181},\"ip\": \"181.191.153.61\"},{\"id\": 102,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1556165928518,\"txnType\": \"credit\",\"amount\": \"$1,688.24\",\"location\": {\"id\": 8,\"address\": \"389, Everest, Barwell Terrace\",\"city\": \"Murillo\",\"zipCode\": 66061},\"ip\": \"119.162.205.226\"},{\"id\": 107,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1559402521261,\"txnType\": \"debit\",\"amount\": \"$1,872.07\",\"location\": {\"id\": 6,\"address\": \"206, Portaline, Brooklyn Avenue\",\"city\": \"Brownlee\",\"zipCode\": 80358},\"ip\": \"181.191.153.61\"},{\"id\": 111,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1557076924093,\"txnType\": \"credit\",\"amount\": \"$2,330.05\",\"location\": {\"id\": 1,\"address\": \"948, Entroflex, Franklin Avenue\",\"city\": \"Ilchester\",\"zipCode\": 84181},\"ip\": \"142.216.23.1\"},{\"id\": 118,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1560694086761,\"txnType\": \"credit\",\"amount\": \"$3,192.75\",\"location\": {\"id\": 6,\"address\": \"206, Portaline, Brooklyn Avenue\",\"city\": \"Brownlee\",\"zipCode\": 80358},\"ip\": \"119.162.205.226\"},{\"id\": 120,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1557871193894,\"txnType\": \"debit\",\"amount\": \"$924.93\",\"location\": {\"id\": 6,\"address\": \"206, Portaline, Brooklyn Avenue\",\"city\": \"Brownlee\",\"zipCode\": 80358},\"ip\": \"132.169.40.222\"},{\"id\": 121,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1561826593797,\"txnType\": \"debit\",\"amount\": \"$3,134.51\",\"location\": {\"id\": 8,\"address\": \"389, Everest, Barwell Terrace\",\"city\": \"Murillo\",\"zipCode\": 66061},\"ip\": \"142.216.23.1\"},{\"id\": 124,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1560330476187,\"txnType\": \"credit\",\"amount\": \"$3,238.70\",\"location\": {\"id\": 6,\"address\": \"206, Portaline, Brooklyn Avenue\",\"city\": \"Brownlee\",\"zipCode\": 80358},\"ip\": \"142.216.23.1\"},{\"id\": 125,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1559783929312,\"txnType\": \"credit\",\"amount\": \"$3,441.63\",\"location\": {\"id\": 7,\"address\": \"770, Deepends, Stockton Street\",\"city\": \"Ripley\",\"zipCode\": 44139},\"ip\": \"132.169.40.222\"},{\"id\": 128,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1560404217056,\"txnType\": \"debit\",\"amount\": \"$1,186.85\",\"location\": {\"id\": 7,\"address\": \"770, Deepends, Stockton Street\",\"city\": \"Ripley\",\"zipCode\": 44139},\"ip\": \"119.162.205.226\"},{\"id\": 129,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1556517581997,\"txnType\": \"debit\",\"amount\": \"$3,482.87\",\"location\": {\"id\": 8,\"address\": \"389, Everest, Barwell Terrace\",\"city\": \"Murillo\",\"zipCode\": 66061},\"ip\": \"35.151.1.82\"},{\"id\": 130,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1559695261267,\"txnType\": \"debit\",\"amount\": \"$317.42\",\"location\": {\"id\": 8,\"address\": \"389, Everest, Barwell Terrace\",\"city\": \"Murillo\",\"zipCode\": 66061},\"ip\": \"119.162.205.226\"},{\"id\": 134,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1561802945256,\"txnType\": \"credit\",\"amount\": \"$965.92\",\"location\": {\"id\": 6,\"address\": \"206, Portaline, Brooklyn Avenue\",\"city\": \"Brownlee\",\"zipCode\": 80358},\"ip\": \"119.162.205.226\"},{\"id\": 135,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1554254315000,\"txnType\": \"debit\",\"amount\": \"$141.50\",\"location\": {\"id\": 1,\"address\": \"948, Entroflex, Franklin Avenue\",\"city\": \"Ilchester\",\"zipCode\": 84181},\"ip\": \"111.83.155.103\"},{\"id\": 137,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1554867084094,\"txnType\": \"debit\",\"amount\": \"$2,569.53\",\"location\": {\"id\": 6,\"address\": \"206, Portaline, Brooklyn Avenue\",\"city\": \"Brownlee\",\"zipCode\": 80358},\"ip\": \"5.116.1.11\"},{\"id\": 139,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1557579078372,\"txnType\": \"credit\",\"amount\": \"$2,762.92\",\"location\": {\"id\": 6,\"address\": \"206, Portaline, Brooklyn Avenue\",\"city\": \"Brownlee\",\"zipCode\": 80358},\"ip\": \"119.162.205.226\"},{\"id\": 145,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1560438366364,\"txnType\": \"debit\",\"amount\": \"$3,121.99\",\"location\": {\"id\": 6,\"address\": \"206, Portaline, Brooklyn Avenue\",\"city\": \"Brownlee\",\"zipCode\": 80358},\"ip\": \"111.83.155.103\"},{\"id\": 151,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1558504716984,\"txnType\": \"credit\",\"amount\": \"$1,701.09\",\"location\": {\"id\": 9,\"address\": \"961, Neptide, Elliott Walk\",\"city\": \"Bourg\",\"zipCode\": 68602},\"ip\": \"181.191.153.61\"},{\"id\": 157,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1561025417910,\"txnType\": \"credit\",\"amount\": \"$2,438.49\",\"location\": {\"id\": 7,\"address\": \"770, Deepends, Stockton Street\",\"city\": \"Ripley\",\"zipCode\": 44139},\"ip\": \"119.162.205.226\"},{\"id\": 166,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1559740888182,\"txnType\": \"debit\",\"amount\": \"$2,451.88\",\"location\": {\"id\": 9,\"address\": \"961, Neptide, Elliott Walk\",\"city\": \"Bourg\",\"zipCode\": 68602},\"ip\": \"5.116.1.11\"},{\"id\": 167,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1558099494221,\"txnType\": \"debit\",\"amount\": \"$2,671.97\",\"location\": {\"id\": 7,\"address\": \"770, Deepends, Stockton Street\",\"city\": \"Ripley\",\"zipCode\": 44139},\"ip\": \"142.216.23.1\"},{\"id\": 177,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1560380372070,\"txnType\": \"credit\",\"amount\": \"$959.88\",\"location\": {\"id\": 8,\"address\": \"389, Everest, Barwell Terrace\",\"city\": \"Murillo\",\"zipCode\": 66061},\"ip\": \"212.215.115.165\"},{\"id\": 184,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1554579202054,\"txnType\": \"credit\",\"amount\": \"$3,717.84\",\"location\": {\"id\": 9,\"address\": \"961, Neptide, Elliott Walk\",\"city\": \"Bourg\",\"zipCode\": 68602},\"ip\": \"35.151.1.82\"},{\"id\": 188,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1554216081353,\"txnType\": \"credit\",\"amount\": \"$1,153.61\",\"location\": {\"id\": 1,\"address\": \"948, Entroflex, Franklin Avenue\",\"city\": \"Ilchester\",\"zipCode\": 84181},\"ip\": \"212.215.115.165\"},{\"id\": 191,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1559101665729,\"txnType\": \"credit\",\"amount\": \"$430.89\",\"location\": {\"id\": 6,\"address\": \"206, Portaline, Brooklyn Avenue\",\"city\": \"Brownlee\",\"zipCode\": 80358},\"ip\": \"35.151.1.82\"},{\"id\": 195,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1558056583495,\"txnType\": \"debit\",\"amount\": \"$189.16\",\"location\": {\"id\": 9,\"address\": \"961, Neptide, Elliott Walk\",\"city\": \"Bourg\",\"zipCode\": 68602},\"ip\": \"132.169.40.222\"},{\"id\": 197,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1554259601254,\"txnType\": \"credit\",\"amount\": \"$2,308.85\",\"location\": {\"id\": 7,\"address\": \"770, Deepends, Stockton Street\",\"city\": \"Ripley\",\"zipCode\": 44139},\"ip\": \"119.162.205.226\"},{\"id\": 198,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1555164373498,\"txnType\": \"credit\",\"amount\": \"$2,639.43\",\"location\": {\"id\": 7,\"address\": \"770, Deepends, Stockton Street\",\"city\": \"Ripley\",\"zipCode\": 44139},\"ip\": \"212.215.115.165\"},{\"id\": 201,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1569412528132,\"txnType\": \"debit\",\"amount\": \"$3,683.03\",\"location\": {\"id\": 6,\"address\": \"206, Portaline, Brooklyn Avenue\",\"city\": \"Brownlee\",\"zipCode\": 80358},\"ip\": \"35.151.1.82\"},{\"id\": 203,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1566561334738,\"txnType\": \"debit\",\"amount\": \"$3,013.97\",\"location\": {\"id\": 7,\"address\": \"770, Deepends, Stockton Street\",\"city\": \"Ripley\",\"zipCode\": 44139},\"ip\": \"5.116.1.11\"},{\"id\": 212,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1564619118271,\"txnType\": \"debit\",\"amount\": \"$3,408.88\",\"location\": {\"id\": 1,\"address\": \"948, Entroflex, Franklin Avenue\",\"city\": \"Ilchester\",\"zipCode\": 84181},\"ip\": \"142.216.23.1\"},{\"id\": 213,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1565296786685,\"txnType\": \"debit\",\"amount\": \"$3,220.14\",\"location\": {\"id\": 1,\"address\": \"948, Entroflex, Franklin Avenue\",\"city\": \"Ilchester\",\"zipCode\": 84181},\"ip\": \"142.216.23.1\"},{\"id\": 225,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1568894452011,\"txnType\": \"debit\",\"amount\": \"$2,108.38\",\"location\": {\"id\": 9,\"address\": \"961, Neptide, Elliott Walk\",\"city\": \"Bourg\",\"zipCode\": 68602},\"ip\": \"35.151.1.82\"},{\"id\": 232,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1569107804438,\"txnType\": \"credit\",\"amount\": \"$3,135.85\",\"location\": {\"id\": 6,\"address\": \"206, Portaline, Brooklyn Avenue\",\"city\": \"Brownlee\",\"zipCode\": 80358},\"ip\": \"132.169.40.222\"},{\"id\": 235,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1566672098896,\"txnType\": \"credit\",\"amount\": \"$2,744.16\",\"location\": {\"id\": 8,\"address\": \"389, Everest, Barwell Terrace\",\"city\": \"Murillo\",\"zipCode\": 66061},\"ip\": \"5.116.1.11\"},{\"id\": 240,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1568544242024,\"txnType\": \"credit\",\"amount\": \"$2,070.92\",\"location\": {\"id\": 1,\"address\": \"948, Entroflex, Franklin Avenue\",\"city\": \"Ilchester\",\"zipCode\": 84181},\"ip\": \"5.116.1.11\"},{\"id\": 241,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1566899821513,\"txnType\": \"debit\",\"amount\": \"$1,236.75\",\"location\": {\"id\": 9,\"address\": \"961, Neptide, Elliott Walk\",\"city\": \"Bourg\",\"zipCode\": 68602},\"ip\": \"181.191.153.61\"},{\"id\": 245,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1568849983123,\"txnType\": \"debit\",\"amount\": \"$1,522.35\",\"location\": {\"id\": 7,\"address\": \"770, Deepends, Stockton Street\",\"city\": \"Ripley\",\"zipCode\": 44139},\"ip\": \"142.216.23.1\"},{\"id\": 247,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1564263573286,\"txnType\": \"debit\",\"amount\": \"$408.17\",\"location\": {\"id\": 9,\"address\": \"961, Neptide, Elliott Walk\",\"city\": \"Bourg\",\"zipCode\": 68602},\"ip\": \"212.215.115.165\"},{\"id\": 249,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1569117159151,\"txnType\": \"debit\",\"amount\": \"$3,614.78\",\"location\": {\"id\": 6,\"address\": \"206, Portaline, Brooklyn Avenue\",\"city\": \"Brownlee\",\"zipCode\": 80358},\"ip\": \"5.116.1.11\"},{\"id\": 253,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1566081309542,\"txnType\": \"credit\",\"amount\": \"$3,515.10\",\"location\": {\"id\": 9,\"address\": \"961, Neptide, Elliott Walk\",\"city\": \"Bourg\",\"zipCode\": 68602},\"ip\": \"132.169.40.222\"},{\"id\": 256,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1563004223065,\"txnType\": \"credit\",\"amount\": \"$619.12\",\"location\": {\"id\": 1,\"address\": \"948, Entroflex, Franklin Avenue\",\"city\": \"Ilchester\",\"zipCode\": 84181},\"ip\": \"5.116.1.11\"},{\"id\": 260,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1566556666749,\"txnType\": \"credit\",\"amount\": \"$209.13\",\"location\": {\"id\": 9,\"address\": \"961, Neptide, Elliott Walk\",\"city\": \"Bourg\",\"zipCode\": 68602},\"ip\": \"132.169.40.222\"},{\"id\": 261,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1567973338308,\"txnType\": \"credit\",\"amount\": \"$2,366.91\",\"location\": {\"id\": 9,\"address\": \"961, Neptide, Elliott Walk\",\"city\": \"Bourg\",\"zipCode\": 68602},\"ip\": \"181.191.153.61\"},{\"id\": 262,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1567629432279,\"txnType\": \"debit\",\"amount\": \"$2,778.55\",\"location\": {\"id\": 9,\"address\": \"961, Neptide, Elliott Walk\",\"city\": \"Bourg\",\"zipCode\": 68602},\"ip\": \"181.191.153.61\"},{\"id\": 271,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1562638297825,\"txnType\": \"debit\",\"amount\": \"$1,577.37\",\"location\": {\"id\": 7,\"address\": \"770, Deepends, Stockton Street\",\"city\": \"Ripley\",\"zipCode\": 44139},\"ip\": \"132.169.40.222\"},{\"id\": 276,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1566970227213,\"txnType\": \"debit\",\"amount\": \"$533.62\",\"location\": {\"id\": 7,\"address\": \"770, Deepends, Stockton Street\",\"city\": \"Ripley\",\"zipCode\": 44139},\"ip\": \"132.169.40.222\"},{\"id\": 277,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1569015381280,\"txnType\": \"credit\",\"amount\": \"$3,816.46\",\"location\": {\"id\": 1,\"address\": \"948, Entroflex, Franklin Avenue\",\"city\": \"Ilchester\",\"zipCode\": 84181},\"ip\": \"5.116.1.11\"},{\"id\": 280,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1566523847955,\"txnType\": \"debit\",\"amount\": \"$1,610.62\",\"location\": {\"id\": 9,\"address\": \"961, Neptide, Elliott Walk\",\"city\": \"Bourg\",\"zipCode\": 68602},\"ip\": \"212.215.115.165\"},{\"id\": 281,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1565986320949,\"txnType\": \"debit\",\"amount\": \"$3,914.73\",\"location\": {\"id\": 6,\"address\": \"206, Portaline, Brooklyn Avenue\",\"city\": \"Brownlee\",\"zipCode\": 80358},\"ip\": \"5.116.1.11\"},{\"id\": 284,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1567641412513,\"txnType\": \"debit\",\"amount\": \"$682.54\",\"location\": {\"id\": 8,\"address\": \"389, Everest, Barwell Terrace\",\"city\": \"Murillo\",\"zipCode\": 66061},\"ip\": \"119.162.205.226\"},{\"id\": 290,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1567991018381,\"txnType\": \"debit\",\"amount\": \"$1,776.49\",\"location\": {\"id\": 9,\"address\": \"961, Neptide, Elliott Walk\",\"city\": \"Bourg\",\"zipCode\": 68602},\"ip\": \"212.215.115.165\"},{\"id\": 297,\"userId\": 2,\"userName\": \"Bob Martin\",\"timestamp\": 1568706241221,\"txnType\": \"debit\",\"amount\": \"$2,113.75\",\"location\": {\"id\": 8,\"address\": \"389, Everest, Barwell Terrace\",\"city\": \"Murillo\",\"zipCode\": 66061},\"ip\": \"142.216.23.1\"}]}";
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

//Convert JSON to POJO
        Temp temp = mapper.readValue(json, Temp.class);
//        System.out.println(temp.getData().size());
        double amount=0;
        for(Data data:temp.getData()){
//            System.out.println(data.getUserId()+" "+data.getIp()+" "+data.getLocation().getId()+" "+data.getAmount());
//            System.out.println(data.getIp().split("\\.").length);
            int ip=Integer.parseInt(data.getIp().split("\\.")[0]);
            int locationId=Integer.parseInt(data.getLocation().getId());
            if(ip >=5 && 50 >= ip && locationId==8){
                System.out.println(ip+" "+data.getAmount().replace("$","").replaceAll(",",""));
                amount+=Double.parseDouble(data.getAmount().replace("$","").replaceAll(",",""));
            }
        }
        System.out.println(amount);
    }
}
