///usr/bin/env jbang "$0" "$@" ; exit $?
//REPOS mavencentral,jitpack
//DEPS com.github.adriens:excuses-sdk:v0.3
//DEPS info.picocli:picocli:4.5.0
import com.github.adriens.excuses.sdk.Excuses;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "nope", mixinStandardHelpOptions = true, version = "nope 0.1",
        description = "nope made with jbang")
class nope implements Callable<Integer> {

    @Parameters(index = "0", description = "The greeting to print", defaultValue = "World!")
    private String greeting;

    public static void main(String... args) {
        int exitCode = new CommandLine(new nope()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        //System.out.println("Hello " + greeting);
        Excuses excuses = new Excuses();
        System.out.println("Random excuse : <" + excuses.pickRandomly() + ">");
        return 0;
    }
}
