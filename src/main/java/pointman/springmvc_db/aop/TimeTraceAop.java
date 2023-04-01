package pointman.springmvc_db.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect //AOP 설정
@Component// config에 수동으로 bean 등록해서 사용해도 된다
public class TimeTraceAop {
    @Around("execution(* pointman.springmvc_db.service..*(..))") //적용 대상 지정
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START:::"+joinPoint.toString());
        try {
            return  joinPoint.proceed();
            }finally {
                long finish = System.currentTimeMillis();
                long timeMs= finish - start;
            System.out.println("END:::"+joinPoint.toString()+" "+timeMs+"ms");
            }

    }

}
