
突然ですが以下のスクリプトの実行結果は

```js
  (function(){
    let i = 0;
    for (i = 0; i < 3; i++) {
      console.log(i);
      setTimeout(function(){ console.log(`hello ${i}`)}, 1000);
    }  
  })();
```

このようになります。

> 0  
> 1  
> 2  
> hello 3  
> hello 3  
> hello 3

oh……全部3になってやがるぜ……。

変数iのスコープがforのブロック外にあるので、`setTimeout`に渡しているコールバック関数は***最新のiの値***を参照します。  
また、`let`で宣言せずに`for (var i = 0; i < 3; i++)`と記述しても同じ結果になります。varは関数以外ではブロックスコープを作りません。

この手のやつ、むかーし（letがないころ）すごいはまりました。イベントリスナーをループ内で設定しようとして「んぁぁぁぁぁぁぁ」ってなってました。
むしろ今日もなってた。

シンプルにこのように記述すれば望み通りの結果になります。

```js
(function(){
  for (let i = 0; i < 3; i++) {
    console.log(i);
    setTimeout(function(){ console.log(`hello ${i}`)}, 1000);
  }  
})();
```
> 0  
> 1  
> 2  
> hello 0  
> hello 1  
> hello 2  

JavaScriptは歴史的な経緯もあり、変数のスコープが少し特殊ですね。

ES6より前であれば以下のようにクロージャを使うといいかもしれません。

```js
(function(){
  for (var i = 0; i < 3; i++) {
    console.log(i);
    var a = function(n) {
      return function() {
        console.log(`hello ${n}`);
      }
    };
    setTimeout(a(i), 1000);
  }  
})();

```