package ScreamInterpretor;

import java.util.List;

interface ScreamCallable {
    int arity();
    Object call(Interpreter interpreter, List<Object> arguments);
    
}
