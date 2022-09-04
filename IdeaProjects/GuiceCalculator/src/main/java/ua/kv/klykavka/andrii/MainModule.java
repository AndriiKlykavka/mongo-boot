package ua.kv.klykavka.andrii;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;
import ua.kv.klykavka.andrii.Operations.*;

public class MainModule implements Module {

    @Override
    public void configure(Binder binder) {

        binder.bind(Operation.class).annotatedWith(Names.named("Addition")).to(Addition.class);
        binder.bind(Operation.class).annotatedWith(Names.named("Division")).to(Division.class);
        binder.bind(Operation.class).annotatedWith(Names.named("Subtraction")).to(Subtraction.class);
        binder.bind(Operation.class).annotatedWith(Names.named("Multiplication")).to(Multiplication.class);

    }
}
