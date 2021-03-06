package spock.genesis.generators.values

import spock.lang.Specification

class ByteArrayGeneratorSpec extends Specification {

    def 'setting seed produces the same sequences for different generators' () {
        given:
            def a = new ByteArrayGenerator().seed(seed).take(100).realized
            def b = new ByteArrayGenerator().seed(seed).take(100).realized
        expect:
            a == b
        where:
            seed << [Long.MIN_VALUE, 100, Long.MAX_VALUE]
    }
}
