import * as io from "http://deno.land/std@0.165.0/io/mod.ts";
import { walk } from "http://deno.land/std@0.165.0/fs/walk.ts";

export type GrepResult = {
    fileName: string;
    line: number;
    text: string;
};

export async function grep(
    root: string,
    word: string,
): Promise<GrepResult[]> {
    const result = [];
    for await (const entry of walk(root, { skip: [/^\.git/]})) { // ファイルを探している for wait ofは非同期を待つ構文
        const file = await Deno.open(entry.path);
        try {
            let line = 1;
            for await (const text of io.readLines(file)) { // ファイル読み込み
                if (text.match(word)) {
                    result.push({
                        fileName: entry.path,
                        line: line,
                        text: text
                    });
                }
                line++;
            }
        } finally {
            file.close();
        }
    }
    return result;
}
