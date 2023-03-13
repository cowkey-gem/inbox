import { assertEquals } from 'https://deno.land/std@0.160.0/testing/asserts.ts'
Deno.test({
    name: 'test foo',
    fn: () => {
        assertEquals(1, 1);
    }
});