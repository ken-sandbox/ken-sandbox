# AndroidAppSample

このリポジトリは、シンプルな Kotlin Android サンプルアプリです。
日本語 / 英語 / 中国語（簡体）に対応した多言語リソースと、簡単な UI テスト（Espresso）を含みます。

## 前提（Windows, PowerShell）
- Android SDK がインストールされていること（通常 `C:\Users\<ユーザー>\AppData\Local\Android\sdk`）。
- Android Emulator（AVD）を使って実機（仮想）でのテストを行います。
- JDK は Android Studio 同梱の OpenJDK か、Temurin 等の JDK を使用します（例: `C:\Program Files\Android\openjdk\jdk-21.0.8`）。

注: OneDrive のようなクラウド同期フォルダにプロジェクトを置くと、UTP（追加テスト出力）などでファイル書き込み/ロックの問題が発生する場合があります。問題が発生する場合は ASCII パス（例: `C:\projects\app_dev`）へ移動するか、OneDrive の同期対象から除外してください。

## 推奨環境変数（PowerShell 用）
以下はセッション内での一時設定例です（PowerShell）：

```powershell
$env:ANDROID_SDK_ROOT = 'C:\Users\pyqjg\AppData\Local\Android\sdk'
$env:Path = "$env:ANDROID_SDK_ROOT\platform-tools;$env:ANDROID_SDK_ROOT\emulator;$env:Path"
$env:JAVA_HOME = 'C:\Program Files\Android\openjdk\jdk-21.0.8'
$env:Path = "$env:JAVA_HOME\bin;$env:Path"
Set-Location 'C:\Users\pyqjg\OneDrive\デスクトップ\app_dev\android-app'
```

（必要に応じてパスをあなたの環境に合わせてください）

## ビルド手順
プロジェクトルート（`android-app`）で次を実行します。

```powershell
# クリーン＋デバッグ APK を作成
.\gradlew.bat clean assembleDebug --no-daemon --info --console=plain
```

生成物:
- デバッグ APK: `app/build/outputs/apk/debug/app-debug.apk`

## エミュレータ（AVD）作成 / 起動（簡易）
Android エミュレータが未作成の場合、Android Studio の AVD Manager から作成してください。コマンドラインで起動する例:

```powershell
# エミュレータ一覧
$env:ANDROID_SDK_ROOT='C:\Users\pyqjg\AppData\Local\Android\sdk'
& "$env:ANDROID_SDK_ROOT\emulator\emulator.exe" -list-avds

# 例: 起動
& "$env:ANDROID_SDK_ROOT\emulator\emulator.exe" -avd app_dev_avd
# 起動後、ブート完了を待つ
adb wait-for-device
# ブート完了確認
adb shell getprop sys.boot_completed
```

## UI テスト（Instrumentation / Espresso）の実行
エミュレータを起動した状態で、以下を実行します。

```powershell
# インストルメンテーションテストを実行
.\gradlew.bat connectedAndroidTest --no-daemon --info --console=plain
```

テスト結果（XML）は次のディレクトリに出力されます:

```
app/build/outputs/androidTest-results/connected/
```

## 注意点 / トラブルシュート
- OneDrive 等の同期フォルダでは `AccessDeniedException` やパス名の問題が発生しやすいです。テストの安定化のために ASCII パスへ移動することを推奨します。
- エミュレータや adb が PATH にない場合、`adb` コマンドが見つからないエラーになります。上記の環境変数を参考に PATH を通してください。
- テストで外部ストレージアクセスや特殊な appops が必要な場合、API レベルやテスト用の追加権限が必要になることがあります。ログの `appops set` エラーは多くの場合無視できますが、問題があればログを共有してください。

## CI のヒント（簡易）
- GitHub Actions でのエミュレータ実行は可能ですが、ランナー上での AVD 作成・起動に時間と設定（アクセラレーションなど）が必要です。必要ならワークフロー例を作成します。

## 次のステップ
- README の追加が完了しました。必要なら:
  - `C:\projects\app_dev` へのコピーと同様の変更適用
  - GitHub Actions ワークフローの追加
  - アプリに言語切替 UI を追加

ご希望を教えてください。