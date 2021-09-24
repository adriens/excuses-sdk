///usr/bin/env jbang "$0" "$@" ; exit $?
//REPOS mavencentral,jitpack
//DEPS com.github.adriens:excuses-sdk:v0.8
//DEPS info.picocli:picocli:4.5.0
import com.github.adriens.excuses.sdk.Excuses;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "nope", mixinStandardHelpOptions = true, version = "nope 0.1",
        description = "nope made with jbang")
class nope implements Callable<Integer> {

    //TODO ajouter valeur par défaut
    @CommandLine.Option(
            names = {"-c", "--category"},
            description = "La catégorie d'excuse (boulot,sport,apero)",
            required = true)
    private String category;

    public static void main(String... args) {
        int exitCode = new CommandLine(new nope()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        Excuses excuses = new Excuses();
        System.out.println(excuses.pickRandomly(category));
        return 0;
    }
}
