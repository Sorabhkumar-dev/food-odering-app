package com.sorabh.grabfood.ui.fragments.qna;

import com.sorabh.grabfood.domain.repository.LocalDBRepository;
import com.sorabh.grabfood.ui.adapter.QNAAdapter;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class QNAFragment_MembersInjector implements MembersInjector<QNAFragment> {
  private final Provider<LocalDBRepository> localRepositoryProvider;

  private final Provider<QNAAdapter> qnaAdapterProvider;

  public QNAFragment_MembersInjector(Provider<LocalDBRepository> localRepositoryProvider,
      Provider<QNAAdapter> qnaAdapterProvider) {
    this.localRepositoryProvider = localRepositoryProvider;
    this.qnaAdapterProvider = qnaAdapterProvider;
  }

  public static MembersInjector<QNAFragment> create(
      Provider<LocalDBRepository> localRepositoryProvider,
      Provider<QNAAdapter> qnaAdapterProvider) {
    return new QNAFragment_MembersInjector(localRepositoryProvider, qnaAdapterProvider);
  }

  @Override
  public void injectMembers(QNAFragment instance) {
    injectLocalRepository(instance, localRepositoryProvider.get());
    injectQnaAdapter(instance, qnaAdapterProvider.get());
  }

  @InjectedFieldSignature("com.sorabh.grabfood.ui.fragments.qna.QNAFragment.localRepository")
  public static void injectLocalRepository(QNAFragment instance,
      LocalDBRepository localRepository) {
    instance.localRepository = localRepository;
  }

  @InjectedFieldSignature("com.sorabh.grabfood.ui.fragments.qna.QNAFragment.qnaAdapter")
  public static void injectQnaAdapter(QNAFragment instance, QNAAdapter qnaAdapter) {
    instance.qnaAdapter = qnaAdapter;
  }
}
