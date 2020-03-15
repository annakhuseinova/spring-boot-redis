import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TransactionDemo {

    public static void main(String[] args) {

        Jedis jedis = new Jedis();
        String friendsPrefix = "friends";
        String userOneId = "4352523";
        String userTwoId = "5552321";

        Transaction transaction = jedis.multi();
        transaction.sadd(friendsPrefix + userOneId, userTwoId);
        transaction.sadd(friendsPrefix + userTwoId, userOneId);
        transaction.exec();
    }
}
