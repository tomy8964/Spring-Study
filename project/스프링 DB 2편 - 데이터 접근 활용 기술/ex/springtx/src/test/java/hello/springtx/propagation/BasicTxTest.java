package hello.springtx.propagation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
@SpringBootTest
public class BasicTxTest {
    @Autowired
    PlatformTransactionManager txManager;


    @TestConfiguration
    static class Config {
        @Bean
        public PlatformTransactionManager transactionManager(DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }
    }

    @Test
    void commit() {
        log.info("트렌잭션 시작");
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionAttribute());

        log.info("트랜잭션 커밋 시작");
        txManager.commit(status);
        log.info("트랜잭션 커밋 완료");
    }

    @Test
    void rollback() {
        log.info("트렌잭션 시작");
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionAttribute());

        log.info("트랜잭션 롤백 시작");
        txManager.rollback(status);
        log.info("트랜잭션 롤백 완료");
    }

    @Test
    void double_commit() {
        log.info("트렌잭션1 시작");
        TransactionStatus tx1 = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("트랜잭션1 커밋");
        txManager.commit(tx1);

        log.info("트렌잭션2 시작");
        TransactionStatus tx2 = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("트랜잭션2 커밋");
        txManager.commit(tx2);
    }

    @Test
    void double_commit_rollback() {
        log.info("트렌잭션1 시작");
        TransactionStatus tx1 = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("트랜잭션1 커밋");
        txManager.commit(tx1);

        log.info("트렌잭션2 시작");
        TransactionStatus tx2 = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("트랜잭션2 롤백");
        txManager.rollback(tx2);
    }

    @Test
    void inner_commit() {
        log.info("외부 트렌잭션 시작");
        TransactionStatus outer = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("outer.isNewTransaction()={}", outer.isNewTransaction());

            log.info("내부 트렌잭션 시작");
            TransactionStatus inner = txManager.getTransaction(new DefaultTransactionAttribute());
            log.info("inner.isNewTransaction()={}", inner.isNewTransaction());
            log.info("내부 트렌잭션 커밋");
            txManager.commit(inner);

        log.info("외부 트렌잭션 커밋");
        txManager.commit(outer);
    }

    @Test
    void outer_rollback() {
        log.info("외부 트렌잭션 시작");
        TransactionStatus outer = txManager.getTransaction(new DefaultTransactionAttribute());

            log.info("내부 트렌잭션 시작");
            TransactionStatus inner = txManager.getTransaction(new DefaultTransactionAttribute());
            log.info("내부 트렌잭션 커밋");
            txManager.commit(inner);

        log.info("외부 트렌잭션 롤백");
        txManager.rollback(outer);
    }

    @Test
    void inner_rollback() {
        log.info("외부 트렌잭션 시작");
        TransactionStatus outer = txManager.getTransaction(new DefaultTransactionAttribute());

            log.info("내부 트렌잭션 시작");
            TransactionStatus inner = txManager.getTransaction(new DefaultTransactionAttribute());
            log.info("내부 트렌잭션 롤백");
            txManager.rollback(inner);
            //참가한 기존 논리 트랜잭션(동기화 매니저)에 rollback-only=true 표시

        log.info("외부 트렌잭션 커밋"); //커밋 시도
        assertThatThrownBy(()->txManager.commit(outer))
                        .isInstanceOf(UnexpectedRollbackException.class);
        // 논리 트랜잭션(동기화 매니저) rollback-only=true 표시보고 rollback
        // UnexpectedRollbackException 예외 던짐
    }

    @Test
    void inner_rollback_requires_new() {
        log.info("외부 트렌잭션 시작");
        TransactionStatus outer = txManager.getTransaction(new DefaultTransactionAttribute());
        log.info("outer.isNewTransaction()={}", outer.isNewTransaction());

            log.info("내부 트렌잭션 시작");
            DefaultTransactionAttribute definition = new DefaultTransactionAttribute();
            definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
            // 신규 트랜잭션 만듬 (기존 트랜잭션에 참여하지 않고)
            TransactionStatus inner = txManager.getTransaction(definition);
            log.info("inner.isNewTransaction()={}", inner.isNewTransaction());

            log.info("내부 트렌잭션 롤백");
            txManager.rollback(inner); // 롤백

        log.info("외부 트렌잭션 커밋");
        txManager.commit(outer); //커밋
    }
}
